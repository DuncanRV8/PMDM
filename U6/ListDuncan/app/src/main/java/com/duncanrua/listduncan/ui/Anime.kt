package com.duncanrua.listduncan.ui

data class Anime(
    val title: String = "",
    val author: String = "",
    val titleJapanese: String = "",
    var favorite: Boolean = false
){
    companion object{
        fun getData() : List<Anime> {
            return listOf(
                Anime("Death Note", "Tsugumi Ohba", "デスノート"),
                Anime("Attack on Titan", "Hajime Isayama", "進撃の巨人"),
                Anime("Naruto", "Masashi Kishimoto", "ナルト"),
                Anime("One Piece", "Eiichiro Oda", "ワンピース"),
                Anime("Fullmetal Alchemist", "Hiromu Arakawa", "鋼の錬金術師"),
                Anime("Sword Art Online", "Reki Kawahara", "ソードアート・オンライン"),
                Anime("My Hero Academia", "Kōhei Horikoshi", "僕のヒーローアカデミア"),
                Anime("Demon Slayer: Kimetsu no Yaiba", "Koyoharu Gotouge", "鬼滅の刃"),
                Anime("Tokyo Ghoul", "Sui Ishida", "東京喰種"),
                Anime("Your Lie in April", "Naoshi Arakawa", "四月は君の嘘")
            )
        }
    }
}
