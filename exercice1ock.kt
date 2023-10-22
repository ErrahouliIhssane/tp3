package com.example.kotliny.TP3
////////////////qst1//////////////////partie1
//class exerciceOCK(var nom:String,var numero:Int,var equipe: Equipe,var nombrepoint:Int) {}

//////////////////qst1//////////partie2
//enum class Equipe(color:String){
//    OCS("rouge"),OCK("bleu")
//}

//fun main(){
//////////////////////qst2/2////////////////partie1/2
//    var list= mutableListOf<exerciceOCK>( exerciceOCK("Imad",5,Equipe.OCK,1),
//                                          exerciceOCK("SalahEdin",10,Equipe.OCS,0),
//                                          exerciceOCK("youssef",5,Equipe.OCK,3))
///////////////////////////qst3//////////////////partie1
//    list.add(exerciceOCK("saad",2,Equipe.OCS,3))
//
//}

//////////////////qst1//////////partie3
enum class Pays{
    MAROC, TUNISIE, EGYPTE, ALGERIE , MOURITANIE
}
//////////////////qst2//////////partie3
data class Joueur(var numero:Int,val nom:String,var cumulnombre:Int) {}
//////////////////qst3//////////partie3
class Equipe(var pays:Pays,var nom_Equipe:String){
    var liste2 = mutableListOf<Joueur>()
    fun recherche(j :Joueur) :Int{
        return liste2.indexOfFirst { it.nom==j.nom }

//        for (i in 0..liste2.size){
//            if (j.nom==liste2[i].nom){
//                return i
//                break
//            }
//        }
//        return -1
    }
    fun ajout(j :Joueur) :Boolean{
        if (recherche(j)!=-1){
            return false
        }else{
            liste2.add(j)
            return true
        } }

    fun suppression(j :Joueur) : Boolean{
        if (recherche(j)!=-1){
            liste2.remove(j)
            return true
        }
        else{
            return false

        } }
    fun setPoints(j :Joueur, points :Int){
        j.cumulnombre=points
    }
    fun Affichage():List<String>{
        var u= mutableListOf<String>()
        for(j in liste2){
           u.add(j.toString())
        }
        return  u
    }
}
fun main(){
    var  equipes= mutableListOf<Equipe>(
        Equipe(Pays.MAROC,"Raja"),
        Equipe(Pays.TUNISIE,"tunise"),
        Equipe(Pays.MOURITANIE,"moritan"),
        Equipe(Pays.EGYPTE,"ahli")
    )
    val joueur1 = Joueur(1, "Imad", 10)
    val joueur2 = Joueur(2, "salahedine", 15)
    val joueur3 = Joueur(3, "youssef", 8)
    val joueur4 = Joueur(4, "saad", 12)

    equipes[0].ajout(joueur1)
    equipes[0].ajout(joueur2)
    equipes[1].ajout(joueur2)
    equipes[2].ajout(joueur3)
    equipes[3].ajout(joueur4)

    equipes[0].setPoints(joueur1, 15)

   for (jou in equipes){
      println(jou.Affichage())
   }
}

