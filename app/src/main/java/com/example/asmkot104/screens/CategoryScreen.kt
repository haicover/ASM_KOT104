package com.example.asmkot104.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.asmkot104.R
import com.example.asmkot104.model.Categories
import com.example.asmkot104.model.Populars
import com.example.asmkot104.model.categoriesItem
import com.example.asmkot104.model.popularItem

data class Chair(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val pic: String
)

data class ArmChair(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val pic: String
)

data class Table(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val pic: String
)

data class Bed(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val pic: String
)

data class Television(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val pic: String
)

val ChairItem = listOf(
    Chair(
        id = 0,
        title = "Ghế 1 ",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://www.raftfurniture.co.uk/media/catalog/product/cache/0138abd0fcf6edc9284837bfb46ecd61/s/o/sol-chair-45x45x85cm-nt-1.0_2.jpg"
    ),
    Chair(
        id = 1,
        title = "Ghế 2",
        price = 12.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReQJcmEb5KFeulVUcIfPLm9ZIucbAVFmyjReXfAZeJvYPPQ1jbAKd6JOds1oA_Ww5uOZ4&usqp=CAU"
    ),
    Chair(
        id = 2,
        title = "Ghế 3",
        price = 29.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_uyI_oHpRLYviorbvwszkwW8gjVHz7NKwta68RH0mjguweWFDi736iwsM0t4EJDoFJXw&usqp=CAU"
    ),
    Chair(
        id = 3,
        title = "Ghế 4",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOEX-a0sk8nvA5gvzaexg2pKcrmGaysBfzWzjuyl9FafO6ouHkXYTRm3QomZiLfQRqhZ0&usqp=CAU"
    ),
    Chair(
        id = 4,
        title = "Ghế 5",
        price = 22.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://m.media-amazon.com/images/I/615tdn5nWtL._AC_UF894,1000_QL80_.jpg"
    ),
)
val ArmChairItem = listOf(
    ArmChair(
        id = 0,
        title = "ArmChair 1",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-BR6ZqEBNhIiK51blMIBuoPL0vTP-ck7cww&s"
    ),
    ArmChair(
        id = 1,
        title = "ArmChair 2",
        price = 12.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIgInyANP-0hE40qzqo5lXQpxfcjob7HbADwCUTR-XW4C9_rXhD-xdwToCIiX6Fpynpzs&usqp=CAU"
    ),
    ArmChair(
        id = 2,
        title = "ArmChair 3",
        price = 29.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeABhm5pW9OMCWhSNzy-y3UHrOGy_YQFksXT9bgTIFKsS7TXuDBZ9d_PeQLXVv4fYfwb0&usqp=CAU"
    ),
    ArmChair(
        id = 3,
        title = "ArmChair 4",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3bPJkL3mQt1WScAkk5Zx7fkG_vuZwz4S3ZBW5wt5luEzdv79AhyOm5gNWKMr_ieBijU8&usqp=CAU"
    ),
    ArmChair(
        id = 4,
        title = "ArmChair 5",
        price = 22.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTE50Iub_lDPJNdWnybmcYUI3FIigLjp516aMJowoE1N9ERfnDZN1XbDF-pzbhNeZaLkyg&usqp=CAU"
    ),
)
val TableItem = listOf(
    Table(
        id = 0,
        title = "Table 1",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://d248k8q1c80cf8.cloudfront.net/WK_Seito_0017_tif_584372fb43.jpg"
    ),
    Table(
        id = 1,
        title = "Table 2",
        price = 12.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://d248k8q1c80cf8.cloudfront.net/WK_Seito_0018_tif_0a1447c0d7.jpg"
    ),
    Table(
        id = 2,
        title = "Table 3",
        price = 29.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://d248k8q1c80cf8.cloudfront.net/05_WK_Seito_0011_tif_936929d56e.jpg"
    ),
    Table(
        id = 3,
        title = "Table 4",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://mfmd.rencdn.com/product/ashley/images/D291-25-ANGLE-SW_BIG.jpg"
    ),
    Table(
        id = 4,
        title = "Table 5",
        price = 22.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYeoRbRzFOMAwB5plhr-FpT9vviLRdjf74LvICAk1LkBjeG4ghLCFvYMqLeigIV947tqE&usqp=CAU"
    ),
)
val BedItem = listOf(
    Bed(
        id = 0,
        title = "Bed 1",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://images.ctfassets.net/t15gr55mpxw1/2eAjfLoPXuKjwgNLuMnSjt/1658e8e5a0cd97c0f57edf498910a885/thuma-the-bed-walnut-pillowboard-dark-charcoal-1__3_.png"
    ),
    Bed(
        id = 1,
        title = "Bed 2",
        price = 12.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://joybird2.imgix.net/configurations/pid_4188/-CF339-WS03/4188-CF339-WS03-hughes-bed-essence-ash-t1-2_t.png"
    ),
    Bed(
        id = 2,
        title = "Bed 3",
        price = 29.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://quokkabeds.com.au/wp-content/uploads/2023/11/RosegumPSD5.jpg"
    ),
    Bed(
        id = 3,
        title = "Bed 4",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLs-jI-eYS_E2efkz_7I9giTN813yR4cyI0g&s"
    ),
    Bed(
        id = 4,
        title = "Bed 5",
        price = 22.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://cdn.shopify.com/s/files/1/2268/9819/files/cavill-grey-fabric-bed-frame-upholstered-double-laura-james-1.png?v=1713530033"
    ),
)
val TelevisionItem = listOf(
    Television(
        id = 0,
        title = "Television 1",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://i.pinimg.com/originals/c4/3e/c0/c43ec0cc106bb2c2914c19deda091015.png"
    ),
    Television(
        id = 1,
        title = "Television 2",
        price = 12.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://www.shutterstock.com/image-vector/retro-tv-vector-illustration-600nw-721325083.jpg"
    ),
    Television(
        id = 2,
        title = "Television 3",
        price = 29.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdh-pGjbeag4iaurUrjG3S3X6tWhA5qFxxrQ&s"
    ),
    Television(
        id = 3,
        title = "Television 4",
        price = 25.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://t4.ftcdn.net/jpg/05/02/26/29/360_F_502262924_FStXklnWAu66ZxI2CJOkQ9teE8Vv4hrF.jpg"
    ),
    Television(
        id = 4,
        title = "Television 5",
        price = 22.00,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        pic = "https://static.digit.in/product/62fbd1bbab2478964564641957db61ce84794b94.jpeg"
    ),
)

fun navigateToCategory(navControl: NavHostController, category: Categories) {
    when (category.title) {
        "Television" -> {
            navControl.navigate("TelevisionScreen")
        }

        "Chair" -> {
            navControl.navigate("ChairScreen")
        }

        "Armchair" -> {
            navControl.navigate("ArmchairScreen")
        }

        "Table" -> {
            navControl.navigate("TableScreen")
        }

        "Bed" -> {
            navControl.navigate("BedScreen")
        }
        // Add more cases for other categories if needed
        "Popular" -> {
            navControl.navigate("PopularsScreen")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoriesScreenPreview() {
    ChairScreen(navControl = rememberNavController())
}

/////////Chair
@Composable
fun ChairScreen(navControl: NavHostController) {
    val filteredChair = ChairItem // Assuming you have a list of categories
    ChairList(navControl = navControl, filteredChair)
}

@Composable
fun ChairList(
    navControl: NavHostController, filteredChair: List<Chair>
) {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .clickable { navControl.popBackStack() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
            Text(
                text = "Chair",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 25.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 45.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredChair.size) { chair ->
                ChairItem(navControl = navControl, chair = filteredChair[chair])
            }
        }
    }
}

@Composable
fun ChairItem(
    navControl: NavHostController,
    chair: Chair,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(width = 157.dp, height = 260.dp)
            .padding(8.dp)
            .clickable {
//                navControl.navigate("detail/${chair.id}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1))
    ) {
        Column {
            Box {
                Image(
                    painter = rememberImagePainter(chair.pic),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                Text(
                    text = chair.title,
                    color = Color(0xff606060),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = "${chair.price}",
                    color = Color(0xff303030),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
    }
}

/////////Table
@Composable
fun TableScreen(navControl: NavHostController) {
    val filteredTable = TableItem // Assuming you have a list of categories
    TableList(navControl = navControl, filteredTable)
}

@Composable
fun TableList(
    navControl: NavHostController, filteredTable: List<Table>
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .clickable { navControl.popBackStack() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
            Text(
                text = "Table",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 25.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 45.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredTable.size) { table ->
                TableItem(navControl = navControl, table = filteredTable[table])
            }
        }
    }
}

@Composable
fun TableItem(
    navControl: NavHostController,
    table: Table,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(width = 157.dp, height = 260.dp)
            .padding(8.dp)
            .clickable {
//                navControl.navigate("detail/${table.id}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1))
    ) {
        Column {
            Box {
                Image(
                    painter = rememberImagePainter(table.pic),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .width(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                Text(
                    text = table.title,
                    color = Color(0xff606060),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = "${table.price}",
                    color = Color(0xff303030),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
    }
}

/////////Armchair
@Composable
fun ArmchairScreen(navControl: NavHostController) {
    val filteredArmChair = ArmChairItem // Assuming you have a list of categories
    ArmchairList(navControl = navControl, filteredArmChair)
}

@Composable
fun ArmchairList(
    navControl: NavHostController, filteredArmChair: List<ArmChair>
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .clickable { navControl.popBackStack() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
            Text(
                text = "ArmChair",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 25.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 45.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredArmChair.size) { armChair ->
                ArmchairItem(navControl = navControl, armChair = filteredArmChair[armChair])
            }
        }
    }
}

@Composable
fun ArmchairItem(
    navControl: NavHostController,
    armChair: ArmChair,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(width = 157.dp, height = 260.dp)
            .padding(8.dp)
            .clickable {
//                navControl.navigate("detail/${armChair.id}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1))
    ) {
        Column {
            Box {
                Image(
                    painter = rememberImagePainter(armChair.pic),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .width(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                Text(
                    text = armChair.title,
                    color = Color(0xff606060),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = "$${armChair.price}",
                    color = Color(0xff303030),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
    }
}

/////////Bed
@Composable
fun BedScreen(navControl: NavHostController) {
    val filteredBed = BedItem // Assuming you have a list of categories
    BedList(navControl = navControl, filteredBed)
}

@Composable
fun BedList(
    navControl: NavHostController, filteredBed: List<Bed>
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .clickable { navControl.popBackStack() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
            Text(
                text = "Bed",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 25.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 45.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredBed.size) { bed ->
                BedItem(navControl = navControl, bed = filteredBed[bed])
            }
        }
    }
}

@Composable
fun BedItem(
    navControl: NavHostController,
    bed: Bed,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(width = 157.dp, height = 260.dp)
            .padding(8.dp)
            .clickable {
//                navControl.navigate("detail/${bed.id}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1))
    ) {
        Column {
            Box {
                Image(
                    painter = rememberImagePainter(bed.pic),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .width(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                Text(
                    text = bed.title,
                    color = Color(0xff606060),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = "$${bed.price}",
                    color = Color(0xff303030),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
    }
}

/////////Television
@Composable
fun TelevisionScreen(navControl: NavHostController) {
    val filteredTelevision = TelevisionItem // Assuming you have a list of categories
    TelevisionList(navControl = navControl, filteredTelevision)
}

@Composable
fun TelevisionList(
    navControl: NavHostController, filteredTelevision: List<Television>
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .clickable { navControl.popBackStack() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
            Text(
                text = "Television",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 25.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 45.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredTelevision.size) { television ->
                TelevisionItem(navControl = navControl, television = filteredTelevision[television])
            }
        }
    }
}

@Composable
fun TelevisionItem(
    navControl: NavHostController,
    television: Television,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(width = 157.dp, height = 260.dp)
            .padding(8.dp)
            .clickable {
//                navControl.navigate("detail/${television.id}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1))
    ) {
        Column {
            Box {
                Image(
                    painter = rememberImagePainter(television.pic),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .width(200.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                Text(
                    text = television.title,
                    color = Color(0xff606060),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = "$${television.price}",
                    color = Color(0xff303030),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
    }
}

/////////Popular
@Composable
fun PopularsScreen(navControl: NavHostController) {
    val filteredPopular = popularItem // Assuming you have a list of categories
    PopularsList(navControl = navControl, filteredPopular)
}

@Composable
fun PopularsList(
    navControl: NavHostController, filteredPopular: List<Populars>
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .clickable { navControl.popBackStack() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
            Text(
                text = "Popular",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 25.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 45.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredPopular.size) { populars ->
                PopularsItem(navControl = navControl, populars = filteredPopular[populars])
            }
        }
    }
}

@Composable
fun PopularsItem(
    navControl: NavHostController,
    populars: Populars,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(width = 157.dp, height = 260.dp)
            .padding(8.dp)
            .clickable {
                navControl.navigate("detail/${populars.id}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1))
    ) {
        Column {
            Box {
                Image(
                    painter = rememberImagePainter(populars.pic),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .width(200.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                Text(
                    text = populars.title,
                    color = Color(0xff606060),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = "$${populars.price}",
                    color = Color(0xff606060),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}