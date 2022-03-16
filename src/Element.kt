abstract class Element(val name: String, val parent: DirectoryElement?) {
    init {
        parent?.children?.add(this)
    }

    val depth: Int get() =
        if(parent == null) 0
        else parent.depth + 1

    val path: String get() =
        if(parent == null) path
        else parent.path + " / " + path
}