import kotlin.math.PI

fun main() {
    val squareCabin = SquareCabin(3,50.0)
    val roundHut = RoundHut(5,7.0)
    val roundTower = RoundTower(5,15.5)

    with(squareCabin) {
    println("\nSquare Cabin\n============")
    println("Capacity: ${capacity}")
    println("Material: ${buildingMaterial}")
    println("Has room? ${hasRoom()}")
    println("Floor area: %.2f".format(floorArea()))
    }
    
    with(roundHut) {
    println("\nRound Hut\n============")
    println("Capacity: ${capacity}")
    println("Material: ${buildingMaterial}")
    println("Has room? ${hasRoom()}")
    println("Floor area: %.2f".format(floorArea()))
    }
    
    with(roundTower) {
    println("\nRound Tower\n============")
    println("Capacity: ${capacity}")
    println("Material: ${buildingMaterial}")
    println("Has room? ${hasRoom()}")
    println("Floors: ${floors}")
    println("Floor area: %.2f".format(floorArea()))
    }
}

abstract class Dwelling(private var residents: Int){
	abstract val buildingMaterial: String    
    abstract val capacity: Int
    
    abstract fun floorArea(): Double
    
    fun hasRoom(): Boolean{
        return residents < capacity
    }
}

class SquareCabin(residents: Int, 
                  val length: Double) : Dwelling(residents){
    override val buildingMaterial = "Wood"
    override val capacity = 6
    
    override fun floorArea(): Double{
        return length * length
    }
}
open class RoundHut(val residents: Int, 
                    val radius: Double) : Dwelling(residents){
    override val buildingMaterial = "Straw"
    override val capacity = 4
    
    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

class RoundTower(residents: Int,
                 radius: Double,
                 val floors: Int = 2) : RoundHut(residents, radius){
    override val buildingMaterial = "Stone"
    override val capacity = 4*floors
    
    override fun floorArea(): Double {
    return super.floorArea() * floors
	}
}