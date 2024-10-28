package com.example.p5userinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable

fun latihaninput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var alamat by remember { mutableStateOf("")}
    var nomortelepon by remember { mutableStateOf("")}
    var gender by remember { mutableStateOf("")}

    var unama by remember { mutableStateOf("")}
    var uemail by remember { mutableStateOf("")}
    var ualamat by remember { mutableStateOf("")}
    var unomortelepon by remember { mutableStateOf("")}
    var ugender by remember { mutableStateOf("")}


    val genderlist = listOf("laki - laki", "perempuan")

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            placeholder = { Text("isi nama anda")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            genderlist.forEach { SelectedGender ->
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = gender == SelectedGender,
                        onClick = {gender = SelectedGender}
                    )
                    Text("$SelectedGender")
                }

            }
        }
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("isi Email anda")},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            placeholder = { Text("isi Alamat anda")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        TextField(
            value = nomortelepon,
            onValueChange = { nomortelepon = it },
            label = { Text("Nomor Telepon") },
            placeholder = { Text("isi Nomor Telepon anda")},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                unama = nama
                uemail = email
                unomortelepon = nomortelepon
                ualamat = alamat
                ugender = gender
            }
        ) {
            Text(text = "Simpan")
        }
        DetailMhs("nama", unama)
        DetailMhs("Kelamin", ugender)
        DetailMhs("email", uemail)
        DetailMhs("no telepon", unomortelepon)
        DetailMhs("alamat", ualamat)
    }
}

@Composable
fun DetailMhs(
    para:String, argu:String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = para,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text= ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}
