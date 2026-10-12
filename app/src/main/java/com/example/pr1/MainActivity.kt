package com.example.pr1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pr1.data.TokenManager
import com.example.pr1.data.model.LoginRequest
import com.example.pr1.ui.theme.Pr1Theme
import com.example.pr1.ui.viewmodel.CommentViewModel
import com.example.pr1.ui.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //pr19
            val tokenManager = TokenManager(applicationContext)

            val commentViewModel: CommentViewModel by viewModels{
                viewModelFactory {
                    initializer {
                        CommentViewModel(tokenManager)
                    }
                }
            }

            val loginViewModel: LoginViewModel by viewModels{
                viewModelFactory {
                    initializer {
                        LoginViewModel(tokenManager, commentViewModel)
                    }
                }
            }

            val loginRequest = LoginRequest(
                identity = "aveliczhanina@yandex.ru",
                password = "root1234"
            )
            loginViewModel.loginPost(loginRequest)

            //pr18
//            val loginViewModel: LoginViewModel = viewModel()
//            val loginRequest = LoginRequest(
//                identity = "aveliczhanina@yandex.ru",
//                password = "root1234"
//            )
//            loginViewModel.loginPost(loginRequest)

            //pr17
//            val productsViewModel: ProductsViewModel = viewModel()
//            productsViewModel.deleteProduct(21)
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