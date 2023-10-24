package com.example.kotliny.TP3

import java.util.Date

class Etape(var nom:String,var Date_debut:String,var Date_fin:String ,var distance:Double,var diffulter: Diffulter) {


}
data class Resultat(var temps_effectue: Double ,var classement: Int){}
class Cyclite(var nom:String,var prenom:String,var nationaliter:String,var age:Int,) {
    var liste_historique = hashMapOf<Etape, Resultat>()

    fun nouvelleEtape(etape: Etape, resultat: Resultat) {
            liste_historique[etape]=resultat
    }
    override fun toString(): String {
        val historiqueCycliste = liste_historique.entries.joinToString("\n") { entry ->
            "Étape: ${entry.key.nom}, Date de début: ${entry.key.Date_debut}, Date de fin: ${entry.key.Date_fin}, " +
                    "Distance: ${entry.key.distance} km, Difficulté: ${entry.key.diffulter}, " +
                    "Temps effectué: ${entry.value.temps_effectue} heures, Classement: ${entry.value.classement}"
        }
        return "Personne(nom='$nom', prenom='$prenom', age=$age, nationnalite=$nationaliter et la list:$liste_historique)"

    }
}
enum class Diffulter{
    FACILE,DEFICCILE
}
fun main(){
    val cyclite=Cyclite("xxx","YYY","morocco",20 )
    val etape1=Etape("etape1","01/01/2023","02/01/2023",180.5,Diffulter.DEFICCILE)
    val result1=Resultat(4.5,3)
    val etape2=Etape("etape2","01/01/2023","02/01/2023",160.5,Diffulter.FACILE)
    val result2=Resultat(3.5,1)
    val etape3=Etape("etape3","01/01/2023","02/01/2023",170.5,Diffulter.DEFICCILE)
    val result3=Resultat(4.0,2)


    cyclite.nouvelleEtape(etape1,result1)
    cyclite.nouvelleEtape(etape2,result2)
    cyclite.nouvelleEtape(etape3,result3)
    println(cyclite)

}