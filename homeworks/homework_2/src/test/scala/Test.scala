import utest._

object Test extends TestSuite {

    val tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 10) == 33)
            assert(Exercises.sumOfDivBy3Or5(4, 10) == 30)
            assert(Exercises.sumOfDivBy3Or5(9, 9) == 9)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(32) == Seq(2))
            assert(Exercises.primeFactor(87) == Seq(3, 29))
            assert(Exercises.primeFactor(74) == Seq(2, 37))
        }
        'test_sumScalars - {
            assert(sumScalars(Vector2D(1, 2), Vector2D(3, 4), Vector2D(5, 6), Vector2D(7, 8)) == 94)
            assert(sumScalars(Vector2D(0, 0), Vector2D(1, 8), Vector2D(1000, 200), Vector2D(4, 8)) == 5600)
            assert(sumScalars(Vector2D(-5, 4), Vector2D(3, 3), Vector2D(1, 6), Vector2D(-5, -8)) == -56)
            assert(sumScalars(Vector2D(15, 0), Vector2D(12, -12), Vector2D(-15, 0), Vector2D(-12, 12)) == 360)
        }

        'test_sumCosines - {
            assert(sumCosines(Vector2D(1, 2), Vector2D(3, 4), Vector2D(5, 6), Vector2D(7, 8)) == 1.9835797185673898)
            assert(sumCosines(Vector2D(-5, 4), Vector2D(3, 3), Vector2D(1, 6), Vector2D(-5, -8)) == -1.0340231895748642)
            assert(sumCosines(Vector2D(15, 0), Vector2D(12, -12), Vector2D(-15, 0), Vector2D(-12, 12)) == 1.4142135623730951)
        }
        'test_sortByHeavyweight - {
            val expect = List(
                "Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold",
                "Tungsten", "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium",
                "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"
            )
            assert(Exercises.sortByHeavyweight(balls) == expect)
        }
    }
}
