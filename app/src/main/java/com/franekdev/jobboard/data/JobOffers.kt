package com.franekdev.jobboard.data

import com.franekdev.jobboard.models.Company
import com.franekdev.jobboard.models.JobOffer
import com.franekdev.jobboard.models.Localization

fun getJobOffersData(): List<JobOffer> {
    return listOf(
        JobOffer(
            id = 1,
            title = "Software Engineer",
            salary = "$80,000 - $100,000",
            description = "We are looking for a skilled software engineer to join our team...",
            localization = Localization(
                country = "USA",
                city = "San Francisco",
                address = "123 Main St"
            ),
            company = Company(
                name = "Tech Solutions Inc.",
                address = "456 Elm St, San Francisco, CA",
                email = "info@techsolutions.com",
                phoneNumber = "(123) 456-7890"
            ),
            isFavorite = true
        ),
        JobOffer(
            id = 2,
            title = "Data Scientist",
            salary = "$90,000 - $120,000",
            description = "We are seeking an experienced data scientist to join our analytics team...",
            localization = Localization(
                country = "USA",
                city = "New York",
                address = "789 Oak St"
            ),
            company = Company(
                name = "Data Analytics Corp.",
                address = "101 Maple Ave, New York, NY",
                email = "hr@dataanalyticscorp.com",
                phoneNumber = "(234) 567-8901"
            ),
            isFavorite = false
        ),
        JobOffer(
            id = 3,
            title = "Graphic Designer",
            salary = "$50,000 - $70,000",
            description = "We are looking for a creative graphic designer to join our marketing team...",
            localization = Localization(
                country = "USA",
                city = "Los Angeles",
                address = "456 Sunset Blvd"
            ),
            company = Company(
                name = "Design Studio XYZ",
                address = "789 Vine St, Los Angeles, CA",
                email = "jobs@designstudioxyz.com",
                phoneNumber = "(987) 654-3210"
            ),
            isFavorite = true
        ),
        JobOffer(
            id = 4,
            title = "Product Manager",
            salary = "$100,000 - $120,000",
            description = "We are seeking a skilled product manager to lead our product development efforts...",
            localization = Localization(
                country = "USA",
                city = "Seattle",
                address = "101 Pine St"
            ),
            company = Company(
                name = "InnovateTech",
                address = "202 Cedar Ave, Seattle, WA",
                email = "careers@innovatetech.com",
                phoneNumber = "(345) 678-9012"
            ),
            isFavorite = false
        ),
        JobOffer(
            id = 5,
            title = "Marketing Specialist",
            salary = "$60,000 - $80,000",
            description = "We are seeking a marketing specialist to develop and implement marketing strategies...",
            localization = Localization(
                country = "USA",
                city = "Chicago",
                address = "321 Lake Shore Dr"
            ),
            company = Company(
                name = "Marketing Masters LLC",
                address = "555 Michigan Ave, Chicago, IL",
                email = "info@marketingmastersllc.com",
                phoneNumber = "(567) 890-1234"
            ),
            isFavorite = true
        ),
        JobOffer(
            id = 6,
            title = "Frontend Developer",
            salary = "$70,000 - $90,000",
            description = "We are seeking a talented frontend developer to join our development team...",
            localization = Localization(
                country = "USA",
                city = "Austin",
                address = "789 Congress Ave"
            ),
            company = Company(
                name = "CodeCrafters Inc.",
                address = "123 Sixth St, Austin, TX",
                email = "hr@codecrafters.com",
                phoneNumber = "(210) 987-6543"
            ),
            isFavorite = false
        ),
        JobOffer(
            id = 7,
            title = "HR Manager",
            salary = "$80,000 - $100,000",
            description = "We are looking for an experienced HR manager to oversee our human resources department...",
            localization = Localization(
                country = "USA",
                city = "Denver",
                address = "456 Broadway"
            ),
            company = Company(
                name = "HR Solutions Group",
                address = "789 Colfax Ave, Denver, CO",
                email = "careers@hrsolutionsgroup.com",
                phoneNumber = "(303) 456-7890"
            ),
            isFavorite = false
        ),
        JobOffer(
            id = 8,
            title = "Quality Assurance Analyst",
            salary = "$60,000 - $80,000",
            description = "We are seeking a detail-oriented quality assurance analyst to test our software products...",
            localization = Localization(
                country = "USA",
                city = "Boston",
                address = "101 Tremont St"
            ),
            company = Company(
                name = "QA Experts Ltd.",
                address = "202 Boylston St, Boston, MA",
                email = "info@qaexperts.com",
                phoneNumber = "(617) 123-4567"
            ),
            isFavorite = false
        ),
        JobOffer(
            id = 9,
            title = "Content Writer",
            salary = "$40,000 - $60,000",
            description = "We are looking for a skilled content writer to create engaging content for our blog and website...",
            localization = Localization(
                country = "USA",
                city = "San Diego",
                address = "321 Broadway"
            ),
            company = Company(
                name = "Content Creators LLC",
                address = "555 Harbor Dr, San Diego, CA",
                email = "jobs@contentcreatorsllc.com",
                phoneNumber = "(619) 890-1234"
            ),
            isFavorite = false
        ),
        JobOffer(
            id = 10,
            title = "Financial Analyst",
            salary = "$70,000 - $90,000",
            description = "We are seeking a financial analyst to provide financial guidance and support to our company...",
            localization = Localization(
                country = "USA",
                city = "Atlanta",
                address = "123 Peachtree St"
            ),
            company = Company(
                name = "Finance Solutions Inc.",
                address = "789 Peachtree St, Atlanta, GA",
                email = "careers@financesolutions.com",
                phoneNumber = "(404) 567-8901"
            ),
            isFavorite = false
        )
    )
}