package com.example.meditationmusicplayer.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationmusicplayer.BottomMenuContent
import com.example.meditationmusicplayer.Feature
import com.example.meditationmusicplayer.R
import com.example.meditationmusicplayer.util.standardQuadFromTo
import com.example.meditationmusicplayer.ui.theme.AquaBlue
import com.example.meditationmusicplayer.ui.theme.Beige1
import com.example.meditationmusicplayer.ui.theme.Beige2
import com.example.meditationmusicplayer.ui.theme.Beige3
import com.example.meditationmusicplayer.ui.theme.BlueViolet1
import com.example.meditationmusicplayer.ui.theme.BlueViolet2
import com.example.meditationmusicplayer.ui.theme.BlueViolet3
import com.example.meditationmusicplayer.ui.theme.ButtonBlue
import com.example.meditationmusicplayer.ui.theme.DarkerButtonBlue
import com.example.meditationmusicplayer.ui.theme.DeepBlue
import com.example.meditationmusicplayer.ui.theme.LightGreen1
import com.example.meditationmusicplayer.ui.theme.LightGreen2
import com.example.meditationmusicplayer.ui.theme.LightGreen3
import com.example.meditationmusicplayer.ui.theme.LightRed
import com.example.meditationmusicplayer.ui.theme.OrangeYellow1
import com.example.meditationmusicplayer.ui.theme.OrangeYellow2
import com.example.meditationmusicplayer.ui.theme.OrangeYellow3
import com.example.meditationmusicplayer.ui.theme.TextWhite
import com.example.meditationmusicplayer.ui.theme.Typography

@Preview
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet Sleep", "Insomania", "Depression"))
            CurrentMeditation()
            FeaturedSection(
                feature = listOf(
                    Feature(
                        title = "Sleep Meditation",
                        iconId = R.drawable.ic_headphone,
                        lightColor = BlueViolet1,
                        mediumColor = BlueViolet2,
                        darkColor = BlueViolet3
                    ),
                    Feature(
                        title = "Tips for Sleeping",
                        iconId = R.drawable.ic_videocam,
                        lightColor = LightGreen1,
                        mediumColor = LightGreen2,
                        darkColor = LightGreen3
                    ),
                    Feature(
                        title = "Night Island",
                        iconId = R.drawable.ic_headphone,
                        lightColor = OrangeYellow3,
                        mediumColor = OrangeYellow2,
                        darkColor = OrangeYellow1
                    ),
                    Feature(
                        title = "Calming Sounds",
                        iconId = R.drawable.ic_headphone,
                        lightColor = Beige1,
                        mediumColor = Beige2,
                        darkColor = Beige3
                    )
                )
            )
            BottomNavMenu(items = listOf(
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("Meditate", R.drawable.ic_bubble),
                BottomMenuContent("Sleep", R.drawable.ic_moon),
                BottomMenuContent("Music", R.drawable.ic_music),
                BottomMenuContent("Profile", R.drawable.ic_profile),
            ), modifier = Modifier)
        }
    }
}

@Composable
fun GreetingSection(name: String = "Shubham") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Good Morning, $name", style = Typography.h1)
            Text(
                text = "We wish you have a good day!",
                style = Typography.h2
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChipsList by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .clickable { selectedChipsList = it }
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedChipsList == it) ButtonBlue else DarkerButtonBlue)
                    .padding(16.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightRed)
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Column {
            Text(text = "Daily Thought", style = Typography.h2)
            Text(text = "Meditation . 3-10 min", style = Typography.body1)
        }
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun FeaturedSection(feature: List<Feature>) {
    Column(Modifier.fillMaxWidth()) {
        Text(text = "Featured", style = Typography.h1, modifier = Modifier.padding(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(feature.size) {
                FeatureItem(feature[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium Colored Path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light Colored Path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(mediumColoredPath, feature.mediumColor)
            drawPath(lightColoredPath, feature.lightColor)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = feature.title,
                style = Typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(DarkerButtonBlue)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun BottomNavMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighLightButton: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(16.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomNavMenuItem(
                item = item,
                isSelected = selectedItemIndex == index,
                activeHighLightButton = activeHighLightButton,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomNavMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighLightButton: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable { onItemClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighLightButton else Color.Transparent)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(text = item.title, color = if (isSelected) activeTextColor else inactiveTextColor)
    }
}
