package com.example.final_pam.KonsultasiPasien.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.final_pam.HomePage.HomeViewModel
import com.example.final_pam.KonsultasiPasien.InformViewModel
import com.example.final_pam.R

@Composable
fun informrealscreen(
    navController: NavController,
    informViewModel: InformViewModel
) {
    val image = painterResource(id = R.drawable.ilness) // Ganti dengan sumber gambar yang sesuai

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        item {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Yuk Kenalin Mental Health!!!",
                color = Color.Black,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Text(
                text = "Kesehatan mental adalah kondisi dimana seseorang memiliki kesejahteraan yang terlihat dari dirinya yang mampu menyadari potensinya sendiri, memiliki kemampuan untuk mengatasi tekanan hidup dan normal di setiap situasi dalam kehidupan, mampu bekerja secara produktif dan menghasilkan, serta mampu memberikan kontribusi kepada komunitasnya. \n" +
                        "\n" +
                        "Menurut Federasi Kesehatan Mental Dunia (World Federation for Mental Health) menjelaskan pengertian dari kesehatan mental sebagai kondisi yang memungkinkan adanya perkembangan yang baik secara fisik, intelektual dan emosional, sepanjang hal itu sesuai dengan keadaan orang lain.\n" +
                        "\n" +
                        "Kesehatan mental yang baik memiliki kondisi batin yang berada dalam keadaan tentram, tenang dan positif, sehingga hal tersebut membuat seseorang untuk menikmati kehidupan sehari-hari dan menghargai orang lain di sekitar. Namun ketika sebaliknya ketika memiliki gangguan kesehatan mental maka akan menimbulkan dampak seperti: emosi selalu tinggi dan cepat marah dan mengalami sakit yang tidak dapat dijelaskan.",
                color = Color.Black,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tips Menjaga Kesehatan Mental." +
                        "\n\n" +
                        "1. Menanamkan mindset positif pada diri sendiri.\n" +
                        "\n" +
                        "2. Rutin dan rajin berolahraga.\n" +
                        "\n" +
                        "3. Istirahat dan tidur yang cukup.\n" +
                        "\n" +
                        "4. Membantu orang lain yang membutuhkan.\n" +
                        "\n" +
                        "5. Berilbur dengan keluarga, pasangan dan kerabat.\n" +
                        "\n" +
                        "6. Meditasi.\n" +
                        "\n" +
                        "7. Memberikan senyuman serta salam pada orang yang kita jumpai.\n" +
                        "\n" +
                        "8. Makan makanan yang sehat dan bergizi\n" +
                        "\n" +
                        "9. Batasi dalam bermain Sosial Media\n" +
                        "\n" +
                        "10. Tidak mengkonsumsi minuman keras dan obat-obatan terlarang.",
                color = Color.Black,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Back to Home")
            }
        }
    }
}