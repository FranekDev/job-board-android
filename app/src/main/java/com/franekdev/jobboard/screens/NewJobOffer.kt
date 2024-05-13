package com.franekdev.jobboard.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.franekdev.jobboard.models.JobOfferInput
import com.franekdev.jobboard.models.all
import com.franekdev.jobboard.models.reset
import com.franekdev.jobboard.models.toJobOffer
import com.franekdev.jobboard.nav.BottomBarScreen
import com.franekdev.jobboard.viewModels.JobOfferViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewJobOfferScreen(jobViewModel: JobOfferViewModel, navController: NavHostController) {
    var jobOfferInput by remember { mutableStateOf(JobOfferInput()) }

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val scrollState = rememberScrollState()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(state = scrollState)
                .padding(10.dp)
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        ) {
            Text(
                text = "Job offer",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                value = jobOfferInput.jobTitle,
                onValueChange = { title ->
                    jobOfferInput = jobOfferInput.copy(jobTitle = title)
                },
                label = { Text("Position") },
                modifier = Modifier.fillMaxWidth(),
            )
            TextField(
                value = jobOfferInput.jobSalary.toString(),
                onValueChange = { salary ->
                    jobOfferInput = jobOfferInput.copy(jobSalary = salary.toInt())
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Salary") },
                modifier = Modifier.fillMaxWidth(),
            )
            TextField(
                value = jobOfferInput.jobDescription,
                onValueChange = { description ->
                    jobOfferInput = jobOfferInput.copy(jobDescription = description)
                },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth(),
            )

            Text(
                text = "Company",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                value = jobOfferInput.companyName,
                onValueChange = { companyName ->
                    jobOfferInput = jobOfferInput.copy(companyName = companyName)
                },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
            )
            TextField(
                value = jobOfferInput.companyAddress,
                onValueChange = { companyAddress ->
                    jobOfferInput = jobOfferInput.copy(companyAddress = companyAddress)
                },
                label = { Text(text = "Address") },
                modifier = Modifier.fillMaxWidth(),
            )
            TextField(
                value = jobOfferInput.companyEmail,
                onValueChange = { companyEmail ->
                    jobOfferInput = jobOfferInput.copy(companyEmail = companyEmail)
                },
                label = { Text(text = "Email") },
                modifier = Modifier.fillMaxWidth(),
            )
            TextField(
                value = jobOfferInput.companyPhoneNumber,
                onValueChange = { phoneNumber ->
                    jobOfferInput = jobOfferInput.copy(companyPhoneNumber = phoneNumber)
                },
                label = { Text(text = "Phone") },
                modifier = Modifier.fillMaxWidth(),
            )

            Text(
                text = "Localization",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                value = jobOfferInput.country,
                onValueChange = { country ->
                    jobOfferInput = jobOfferInput.copy(country = country)
                },
                label = { Text("Country") },
                modifier = Modifier.fillMaxWidth(),
            )
            TextField(
                value = jobOfferInput.city,
                onValueChange = { city ->
                    jobOfferInput = jobOfferInput.copy(city = city)
                },
                label = { Text("City") },
                modifier = Modifier.fillMaxWidth(),
            )
            TextField(
                value = jobOfferInput.address,
                onValueChange = { address ->
                    jobOfferInput = jobOfferInput.copy(address = address)
                },
                label = { Text("Address") },
                modifier = Modifier.fillMaxWidth(),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End

            ) {
                Button(
                    onClick = {
                        if (!jobOfferInput.all()) {
                            scope.launch {
                                snackbarHostState.showSnackbar("Please fill all fields")
                            }
                            return@Button
                        }

                        jobViewModel.addJobOffer(jobOfferInput.toJobOffer())
                        jobOfferInput.reset()
                        navController.navigate(BottomBarScreen.Home.route)
                    },
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                ) {
                    Text(
                        text = "Add offer",
                        color = Color.DarkGray,
                    )
                }
            }
        }
    }
}
