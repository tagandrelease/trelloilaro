package pl.pej.trelloilaro.api.model

import play.api.libs.json.{JsNull, JsSuccess, Reads, JsPath}


trait JsonUtil {

  /**
   * Reads a Option[Option[T]] search optional or nullable field at JsPath (field not found is None, found null field is Some(None)
   * and other cases are Error).
   *
   * It runs through JsValue following all JsPath nodes on JsValue except last node:
   * - If one node in JsPath is not found before last node => returns JsError( "missing-path" )
   * - If all nodes are found till last node, it runs through JsValue with last node =>
   *   - If last node if not found => returns None
   *   - If last node is found with value "null" => returns Some(None)
   *   - If last node is found => applies implicit Reads[T]
   *
   *   A a tweak of the default behaviour in the framework was needed eg because of
   *   "idOrganization" : null, which tells us, that board has no organization
   *    - defaultly we'd get None, we want to get Some(None).
   *
   */
  implicit class DoubleNullablePath(path: JsPath) {

    def readNullableNullable[A](implicit reads: Reads[A]) = Reads[Option[Option[A]]] { json =>
      path.applyTillLast(json).fold(
        jserr => jserr,
        jsres => jsres.fold(
          _ => JsSuccess(None),
          a => a match {
            case JsNull => JsSuccess(Some(None))
            case js => reads.reads(js).repath(path).map(x => Some(Some(x)))
          }
        )
      )
    }


  }

}
