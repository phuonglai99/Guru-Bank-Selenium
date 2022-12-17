package CommonMethod;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TakeCapture {
    public static void takeScreenShot(WebDriver driver) throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        String time = date.format(now);
        String file = "D:\\guru_bank\\GuruBank\\result\\" + time + ".jpg";
        System.out.println(file);
        ImageIO.write(screenshot.getImage(), "jpg", new File(file));

    }
}
