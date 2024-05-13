package com.franekdev.jobboard.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.franekdev.jobboard.models.Company
import com.franekdev.jobboard.models.JobOffer

@Composable
fun JobOfferScreen(jobOffer: JobOffer) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Text(
            text = jobOffer.title ?: "",
            fontSize = 25.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(16.dp, 4.dp),
        )
        Text(
            text = jobOffer.salary.let { "Salary: $it" },
            fontSize = 15.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(16.dp, 4.dp),
        )

        JobDescription(jobOffer.description)
        CompanyDetails(jobOffer.company)
    }
}

@Composable
fun JobDescription(description: String?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = "Description",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(5.dp, 0.dp),
            )
            Text(
                text = description ?: "No description",
                fontSize = 14.sp,
                lineHeight = 17.sp,
                modifier = Modifier
                    .padding(5.dp, 0.dp),
            )
        }
    }
}

@Composable
fun CompanyDetails(company: Company) {
    val context = LocalContext.current

    val dialIntent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:${company.phoneNumber}")
    }

    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:${company.email}")
    }

    val addressIntent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse("geo:0,0?q=${company.address}")
    }

    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            CompanyDetail(text = company.name, fontSize = 18.sp)
            CompanyDetail(text = company.phoneNumber, fontSize = 14.sp, icon = Icons.Outlined.Phone) {
                context.startActivity(dialIntent)
            }
            CompanyDetail(text = company.email, fontSize = 14.sp, icon = Icons.Outlined.Email) {
                context.startActivity(emailIntent)
            }
            CompanyDetail(text = company.address, fontSize = 14.sp, icon = Icons.Outlined.LocationOn) {
                context.startActivity(addressIntent)
            }
        }
    }
}

@Composable
fun CompanyDetail(text: String, fontSize: TextUnit, icon: ImageVector? = null, onClick: (() -> Unit)? = null) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = "Info",
                modifier = Modifier
                    .size(13.dp)
            )
        }
        Text(
            text = text,
            fontSize = fontSize,
            modifier = Modifier
                .padding(5.dp, 0.dp)
                .clickable {
                    onClick.let { it?.invoke() }
                }
        )
    }
}