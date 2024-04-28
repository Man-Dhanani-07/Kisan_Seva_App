package com.man.fapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CropDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_detail);
        TextView textView = findViewById(R.id.textView);
        ImageView imageView = findViewById(R.id.imageView);

        String crop = getIntent().getStringExtra("crop");
        int imageId = getIntent().getIntExtra("image", 0);
        if (crop != null && imageId != 0) {
            String detail = getDetailForCrop(crop);
            textView.setText(detail);
            imageView.setImageResource(imageId);
        }
    }
    private String getDetailForCrop(String crop) {
        switch (crop) {
            case "Wheat":
                return "➤In South Central Washington, you’ll find one of the driest wheat-growing regions in the entire world.\n " + "\n" + "➤Receiving only 6-8 inches of rain per year, many farmers in this area rely on no-till to conserve water, maximize yields and earn better profits.\n" + "\n" + " ➤Average yields can be as low as 18 bushels per acre, compared to upwards of 120 bushels per acre in the higher rainfall area of the Palouse, which is located in eastern Washington.\n " + "\n" + "➤Though margins are tight, wheat farming in this area can still be profitable with careful management.To get the highest yield, farmers need to seed winter wheat in late August or early September after a year of fallow conditions. The resulting 13-month fallow period allows enough moisture from winter and spring rains to accumulate in the soil for fall-seeded wheat to get established.\n" + "\n" + " ➤In this area, if you can’t plant in late summer into deep seed-zone moisture in fallow, then you have to wait for fall rains in mid-October or later,” says Washington State University agronomist Bill Schillinger.\n" + "\n";
            case "Rice":
                return "➤The soils of Karnataka are laterite, red sandy or gravelly, red loamy, deltaic and coastal alluvium.\n" + "\n" + "➤Karnataka state is having varied type of climate, ranging from humid to sub-humid.\n" + "\n" + "➤Laterite and lateritic soils are found in the coastal districts of north and south Kanara, parts of Belgaum, Shimoga, Chickmagalore, Hassan and Coorg.\n" + "\n" + "➤The black soils are found in the districts of Belgaum, Dharwar, Bidar, Raichur and parts of Bellary. These soils are calcareous, enriched with bases and alkaline.\n" + "\n" + "➤The districts of Mysore and parts of Hassan are having red soils where as some parts of shimoga and Chickmagalore districts are having red loam soils. These soils are well-drained and light-textured.\n" + "\n" + "➤Black and red soils are found in the districts of Belgaum, Bijapur, Dharwar, Raichur, Bellary and Chitradurga.\n" + "\n" + "➤Generally, upland areas are having red soils and lowland areas are having black soils.\n" + "\n";
            case "Corn":
                return "➤Water is one of the important inputs in crop production. Dry Spells during flowering stage of rainfed maize reduces productivity of Kharif maize.\n" + "\n" + "➤Even though the productivity of rabi maize is high, area is less and hence overall average productivity of maize in India is only 1667 Kg/ha compared to world productivity of 3778 Kg/ha.\n" + "\n" + "➤Efficient water management is the key to increase the productivity of maize in India.\n" + "\n" + "➤Maize is a sensitive crop to moisture.\n" + "\n" + "➤Excess moisture in the initial stages is harmful to crop. Hence arrangements must be made to remove excess water upto knee high stage.\n" + "\n" + "➤Water stress at flowering and seed formation stages reduces the yield of crop.\n" + "\n" + "➤Water stress hastens tasseling (Male Flowers), pollen dehiscence and delays silking (emergence of female flowers). Result is barrenness due to failure of pollination.\n" + "\n" + "➤Water stress at flowering reduces yield of crop by 40 to 80 percent. Therefore in the initial stages upto rank vegetative growth, irrigations should be scheduled at longer intervals where as during flowering at shorter intervals.\n" + "\n";
            case "Potato":
                return "➤Potato basically requires relatively mild temperature during early growth and cool weather during tuber development.\n" + "\n" + "➤It does well under well-distributed rains or moist weather situations to high temperature, humidity rains are not conducive to potatoes as these lead to insect-pest, disease, viruses epidemics.\n" + "\n" + "➤Impeded drainage or lack of aeration also is considered harmful as it restricts the tuber development.\n" + "\n" + "➤Therefore, climatic conditions are very crucial for determining the potato yield.\n" + "\n" + "➤Its general and specific climatic requirements are delineated as under.\n" + "\n" + "➤Potato is a temperate or cool season crop which needs a low temperature, lower humidity, less windy and bright sunny days.\n" + "\n" + "➤It thrives best in cool regions where there is sufficient moisture and fertile soil.\n" + "\n" + "➤Potato needs about 25°C at the time of germination, about 20°C for vegetative growth but between 17-20°C for tuberization and tuber development.\n" + "\n" + "➤It is noticed that higher temperature has an adverse effect on the tuber growth, where as temperature above 30°C stops tuber formation completely.\n" + "\n" + "➤It is probably because at higher temperature the rate of respiration increases and the carbohydrate formed by the process of photosynthesis is consumed rather than stored in the tubers.\n" + "\n" + "➤Under higher temperature the plants are elongated leaves become wrinkled and plants have silky appearance.\n" + "\n" + "➤Tubers do not develop under such situations.\n" + "\n" + "➤Cloud days, rains and high humidity are very congenial for spread of fungal, viral and bacterial diseases, and such conditions are not good for the crop.\n" + "\n";
            case "Tomato":
                return "➤While thinking about tomato cultivation, we have to consider the climatic requirements because it is very important factor in successful tomato farming.\n" + "\n" + "➤Tomato requires warm climate as well as cool climate, but it is a warm season crop. Tomato plant do not want frost and high humidity.\n" + "\n" + "➤Pigmentation, fruit set, fruit colour are affected by light intensity.\n" + "\n" + "➤For seed germination, seedling growth, flowering, etc. it requires different-different climatic range.\n" + "\n" + "➤Physiological activities slow down when plant tissues are adversely affected by above 380C and below 100C temperature.\n" + "\n" + "➤Tomato plants thrives well in temperature 100C to 300C with optimum range of temperature is 21-240C.\n" + "\n" + "➤The temperature below 160C and above 270C are not desirable.\n" + "\n" + "➤Tomato plants requires low to medium rainfall. It does not withstand frost and does well under average monthly temperature of 21 to 230C.\n" + "\n" + "➤Sometimes fruit cracking is also happen because of of long dry and water stress, so avoiding long dry and water stress is good for tomato fruits.\n" + "\n" + "➤At the time of fruit set, bright sunshine is very good for colour of fruits, because bright sunshine helps to develop dark red coloured fruits\n" + "\n" + "➤At the period of seed germination temperature requirement is minimum 110C, Maximum 340C and suitable temperature is 16-29.\n" + "\n";
            default:
                return "";
        }
    }
}
