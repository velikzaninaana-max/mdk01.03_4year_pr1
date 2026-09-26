package com.example.pr1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr1.ui.theme.Pr1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //pr17
            val productsViewModel: ProductsViewModel = viewModel()
            productsViewModel.deleteUser(21)
            //pr16
//            val userViewModel: UserViewModel = viewModel()
//            userViewModel.updateUser()

            //pr15
//            val recipeViewModel: RecipeViewModel  = viewModel()
//            val recipe = Recipe(
//                name = "Традиционная паэлья с морепродуктами",
//                instructions = listOf("Очистите креветки и кальмары.",
//                    "Мелко нарежьте лук, чеснок и болгарский перец.",
//                    "Томаты натрите на терке, удалив кожуру.",
//                    "Разогрейте оливковое масло на большой сковороде.",
//                    "Обжарьте морепродукты по 1–2 минуты с каждой стороны, затем переложите их на тарелку.",
//                    "В той же сковороде обжарьте лук и чеснок до мягкости.",
//                    "Добавьте перец, а через 3 минуты — натертые томаты и паприку.",
//                    "Тушите 5 минут.",
//                    "Всыпьте рис круглозерный (лучше сорта Бомба) и обжаривайте 2 минуты, чтобы он впитал ароматы.",
//                    "Залейте горячим бульоном со щепоткой шафрана.",
//                    "Варите на среднем огне 15 минут, не перемешивая, чтобы на дне образовалась аппетитная корочка."),
//                tags = listOf("Обед", "Ужин", "Морепродукты", "ИспанскаяКухня", "ПраздничноеБлюдо"),
//                rating = 4.9
//            )
//            recipeViewModel.addRecipe(recipe)

            //pr14
            //val productViewModel: ProductsViewModel = viewModel()
            //productViewModel.fetch()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pr1Theme {
        Greeting("Android")
    }
}