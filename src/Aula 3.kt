import java.io.File

fun dirFiles(dir: File): List<File> {
    val files = mutableListOf<File>()
    dir.listFiles().forEach {
        if(it.isFile)
            files.add(it)
    }
    return files
}

fun dirFilesRec(dir: File, funcao: (File)-> Boolean): List<File> {
    fun dirFilesRecAux(dir: File, list: MutableList<File>){
        dir.listFiles().forEach {
            if (it.isFile && funcao(it))
                list.add(it)
        }
    }
    val list = mutableListOf<File>()
    dirFilesRecAux(dir, list)
    return list
}


fun main() {
    val root = File(System.getProperty("user.dir"))
    println(dirFilesRec(root) { f -> true })
}

