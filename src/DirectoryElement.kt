import javafx.scene.Parent

class DirectoryElement(name: String, parent: DirectoryElement?): Element(name, parent){
    val children = mutableListOf<Element>()
}

fun main(){
    val root = DirectoryElement("A", null)
    val f1 = FileElement("1", root)
    val f2 = FileElement("2", root)
    val b = FileElement("B", root)
    val element: Element = DirectoryElement("C", root)
    println(element.depth)
}