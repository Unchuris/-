package omstu.com.osh.ui.main.training.regulations

import omstu.com.osh.data.entities.PdfFile

object PdfNames {

    private const val dir = "pdf/"

    private const val OBYZANNOSTI_PDF = "${dir}Obyazannosti_Rabochikh_I_Sluzhaschikh.pdf"
    private const val PAMYATKA_PDF = "${dir}Pamyatka_Suot.pdf"
    private const val PORYADOK_PDF = "${dir}Poryadok_Organizatsii_Ognevykh_Gazoopasnykh_Remontnykh_I_Drugikh_Rabot_Povyshennoy_Opasnosti.pdf"
    private const val PRAVILA_PDF = "${dir}Pravila_Po_Okhrane_Truda_Na_Lineynykh_Sooruzheniakh_Kabelnykh_Liny_Svyazi.pdf"
    private const val TREBOVANIA_PDF = "${dir}Trebovania_Bezopasnosti_Pri_Expluatatsii_Obektov_Magistralnykh_Truboprovodov.pdf"
    private const val OKHRANA_TRUDA_PDF = "${dir}Okhrana_Truda_Pri_Rabote_Na_Rrs.pdf"
    private const val PORYADOK_ORGANIZATSII_PDF = "${dir}Poryadok_Organizatsii_I_Provedenia_Rassledovany_Neschastnykh_Sluchaev.pdf"
    private const val PORYADOK_OBUCHENIA_PDF = "${dir}Poryadok_Organizatsii_I_Obuchenia_I_Proverki_Znany_Rabotnikov.pdf"

    val list = listOf(
        PdfFile(OBYZANNOSTI_PDF,  "Обязанности рабочих и служащих."),
        PdfFile(PAMYATKA_PDF,  "Памятка СУОТ."),
        PdfFile(PORYADOK_PDF,  "Порядок организации огневых, газоопасных, ремонтных и других работ повышенной опасности."),
        PdfFile(PRAVILA_PDF,  "Правила по охране труда на линейных сооружениях кабельных линий связи."),
        PdfFile(TREBOVANIA_PDF,  "Требования безопасности при эксплуатации объектов магистральных трубопроводов."),
        PdfFile(OKHRANA_TRUDA_PDF,  "Правила по охране труда на радиорелейных линиях связи."),
        PdfFile(PORYADOK_ORGANIZATSII_PDF,  "Порядок организации и проведения расследований несчастных случаев."),
        PdfFile(PORYADOK_OBUCHENIA_PDF,  "Порядок организации и обучения и проверки знаний работников.")
    )
}
