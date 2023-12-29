package mai.project.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.myapplication.ui.theme.MyApplicationTheme

/**
 * 第 1 題：用 Kotlin 寫一個管理名片的聯絡資訊(Contact)的class，成員具有姓名(Name)、電子郵件(email)、手機(phone)三項，都是字串資訊；但可以只有指定姓名與電子郵件兩項。
 *
 * 查看 [Contact]
 * ```
 * data class Contact(
 *     val name: String,
 *     val email: String,
 *     val phone: String? = null,
 * )
 * ```
 * 第 2 題：jetpack compose的Colors類別有哪些成員?請詳細列出每一個並說明其意義與用途。
 * ```
 * Jetpack Compose 的 Colors 類別是用於定義 UI 主題中各種顏色的。
 * - primary - 這是 App 的主要品牌顏色。用於最常看到的 UI 元素，例如按鈕。
 * - primaryVariant - 這是主要顏色的一個變體，用於更小的 UI 元素，以補充主要顏色。
 * - secondary - 這是 App 的第二品牌顏色。用於區分與主要品牌顏色不同的 UI 元素。
 * - secondaryVariant - 這是次要顏色的變體，用於需要稍微不同於次要顏色的 UI 元素。
 * - background - 用於 App 的背景顏色。
 * - surface - 用於 UI 元素的表面顏色，如 卡片 和 dialog。
 * - error - 用於指示錯誤或問題，例如錯誤訊息和錯誤的輸入欄位。
 * - onPrimary - 用於主要顏色上的 文字 和 icon 顏色。
 * - onSecondary - 用於次要顏色上的 文字 和 icon 顏色。
 * - onBackground - 用於背景顏色上的 文字 和 icon 顏色。
 * - onSurface - 用於表面顏色上的 文字 和 icon 顏色。
 * - onError - 用於錯誤顏色上的 文字 和 icon 顏色。
 * - isLight - 這是一個 Boolean，用於表示這個系統是否為【亮色主題】。
 * ```
 * 第 3 題：TextField中設定輸入類型是靠甚麼?這個類別又有哪些成員?
 * ```
 * 1. TextField 設定輸入類型是通過 keyboardOptions 參數來實現的。
 * 2. keyboardOptions 參數有以下成員：
 * - keyboardType -> 用於指定鍵盤類型。(可能是數字、文字、Email等)
 * - imeAction -> 用於指定輸入法編輯器（IME）的動作按鈕顯示什麼。(可能是收起鍵盤、下一個、完成等)
 * - capitalization -> 用於指定鍵盤的大寫模式。(可能是所有字母大寫、首字母大寫等)
 * - autoCorrect -> 用於指定是否應自動更正輸入的文字。
 * ```
 *
 * 第 4 題：用 Jetpack Compose 設計一個按鈕，字樣為"知道了"，指定顏色為淡綠色、邊框紫色又粗細為15、圓角型。
 * ```
 * @Composable
 * fun CustomButton(
 *     modifier: Modifier = Modifier,
 *     onClick: () -> Unit = { }
 * ) {
 *     Button(
 *         onClick = onClick,
 *         modifier = modifier
 *             .fillMaxWidth()
 *             .border(width = 15.dp, color = Color.Magenta, shape = RoundedCornerShape(50)),
 *         colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
 *     ) {
 *         Text("知道了")
 *     }
 * }
 * ```
 * 第 5 題：透過Jetpack Compose設計一個圓型進度條，寬度20、顏色深綠。
 * ```
 * @Composable
 * fun CustomCircularProgressIndicator() {
 *     CircularProgressIndicator(
 *         color = Color.Green,
 *         strokeWidth = 20.dp,
 *         modifier = Modifier.size(150.dp) // 您可以根據需要調整這個尺寸
 *     )
 * }
 * ```
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val context = LocalContext.current
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val contact = Contact("Mai", "example", "0912345678")
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting(contact.toString())
                        Spacer(modifier = Modifier.size(20.dp))
                        CustomButton {
                            Toast.makeText(context, "知道了", Toast.LENGTH_SHORT).show()
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        CustomCircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = name, modifier = modifier.fillMaxWidth())
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { }
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .border(width = 15.dp, color = Color.Magenta, shape = RoundedCornerShape(50)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
    ) {
        Text("知道了")
    }
}

@Composable
fun CustomCircularProgressIndicator() {
    CircularProgressIndicator(
        color = Color.Green,
        strokeWidth = 20.dp,
        modifier = Modifier.size(150.dp) // 您可以根據需要調整這個尺寸
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        val contact = Contact("Mai", "example", "0912345678")
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting(contact.toString())
            Spacer(modifier = Modifier.size(20.dp))
            CustomButton()
            Spacer(modifier = Modifier.size(20.dp))
            CustomCircularProgressIndicator()
        }
    }
}