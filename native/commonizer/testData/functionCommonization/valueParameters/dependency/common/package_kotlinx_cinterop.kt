// this is to avoid missing Kotlin/Native stdlib
package kotlinx.cinterop

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.BINARY)
annotation class ObjCMethod(val selector: String, val encoding: String, val isStret: Boolean)
