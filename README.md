# Java Loan Application program
This java program generates personalized emails for the loan applicants using their account information.
1. applicants.txt contains the applicant’s UserID (a 4-digit number), name, loan amount, and the applicant’s credit score, each column separated by a tab.
2. template.txt contains the template of the letter that we want to personalize for each applicant.

The program reads the two given files and generates letters (one letter for each applicant) with the NAME and AMOUNT placeholders replaced by the corresponding values
from the applicants.txt file. The other two placeholders will be replaced according to the following rules:
- If the applicant’s credit score is less than 701, then the interest rate is 4.15%, and the monthly
payment (in dollars) would be calculated using the formula loan amount*0.00486.
- If the applicant’s credit score is greater than 700, then the interest rate is 3.05% and the
monthly payment (in dollars) would be calculated using the formula loan
amount*0.00424.

each personalized letter is saved as a separate file with the following naming convention –
Letterxx_UserID.txt, where xx is the serial number (01, 02, 03, ...) and UserID is the
user ID of the applicant for whom the personalized email is being generated.
