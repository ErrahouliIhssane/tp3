package com.example.kotliny.TP3

import java.util.Date

class Etape(var nom:String,var Date_debut:String,var Date_fin:String ,var distance:Double,var diffulter: Diffulter) {


}
//data class Resultat(var temps_effectue: Double ,var classement: Int){}
sealed class Resultat {
    data class Termine(val temps_effectue: Double, var classement: Int) : Resultat()
    data class Abandonne(val distanceParcourue: Int, val raison: String) : Resultat()
}
class Cyclite(var nom:String,var prenom:String,var nationaliter:String,var age:Int,) {
    var liste_historique = hashMapOf<Etape, Resultat>()

    fun nouvelleEtape(etape: Etape, resultat: Resultat) {
            liste_historique[etape]=resultat
    }
override fun toString(): String {
    var result = "Personne(nom='$nom', prenom='$prenom', age=$age, nationnalite=$nationaliter et la list:$liste_historique)"
    for ((etape, resultat) in liste_historique) {
        result += "Nom: ${etape.nom}, Date de début: ${etape.Date_debut}, Date de fin: ${etape.Date_fin}, Distance: ${etape.distance}, Difficulté: ${etape.diffulter}\n"
        when (resultat) {
            is Resultat.Termine -> result += "Temps effectué: ${resultat.temps_effectue}, Classement: ${resultat.classement}\n"
            is Resultat.Abandonne -> result += "Distance parcourue: ${resultat.distanceParcourue}, Raison: ${resultat.raison}\n"
        }
    }
    return result
}
}
enum class Diffulter{
    FACILE,DEFICCILE
}
fun main(){
    val cyclite=Cyclite("xxx","YYY","morocco",20 )
    val etape1=Etape("etape1","01/01/2023","02/01/2023",180.5,Diffulter.DEFICCILE)

    val etape2=Etape("etape2","01/01/2023","02/01/2023",160.5,Diffulter.FACILE)

    val etape3=Etape("etape3","01/01/2023","02/01/2023",170.5,Diffulter.DEFICCILE)



    cyclite.nouvelleEtape(etape1,Resultat.Termine(120.0, 10))
    cyclite.nouvelleEtape(etape2,Resultat.Termine(80.0, 4))
    cyclite.nouvelleEtape(etape3,Resultat.Termine(160.0, 5))
    println(cyclite)

}