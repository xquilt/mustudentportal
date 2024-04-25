package com.polendina.mustudentportal.loginpage

data class University(
    val name: String,
    val portal: String,
    val academicYear: String,
    val creditHour: String,
)

val universities = listOf<University>(
    University(name = "جامعة المنصورة", portal = "http://stdportal.mans.edu.eg", academicYear = "http://credit.mans.edu.eg", creditHour = ""),
    University(name = "جامعة دمياط", portal = "http://stdportal.mans.edu.eg", academicYear = "http://credit.mans.edu.eg", creditHour = ""),
    University(name = " مصر العالى للتجارة والحاسبات بالمنصورة", portal =  "http://stdportal.mans.edu.eg", academicYear = "http://credit.mans.edu.eg", creditHour = ""),
    University(name = "المعهد العالى للخدمة الاجتماعية - بورسعيد", portal = "http://stdportal.mans.edu.eg", academicYear = "http://credit.mans.edu.eg", creditHour = ""),
    University(name = "جامعة المنيا", portal = "http://stdportal.mans.edu.eg", academicYear = "http://credit.mans.edu.eg", creditHour = ""),
    University(name = "جامعة قناة السويس", portal = "http://stdportal.mans.edu.eg", academicYear = "http://credit.mans.edu.eg", creditHour = ""),
    University(name = "جامعة الأزهر", portal = "http://stdportal.mans.edu.eg", academicYear = "http://credit.mans.edu.eg", creditHour = "https://academic.com")
)
