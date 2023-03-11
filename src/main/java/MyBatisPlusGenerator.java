import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.ibatis.annotations.Mapper;

public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        PackageConfig packageConfig = new PackageConfig.Builder().parent("com.guico.authorplat").build();
        StrategyConfig strategyConfig = new StrategyConfig.Builder().addInclude("t_user","t_role","t_permission","t_article","t_category", "t_tag").build();
        FastAutoGenerator.create("jdbc:mysql://101.33.210.228:3306/author_plat?useUnicode=true&characterEncoding=utf-8&useSSL=false",
                "author_plat", "F6FWtzj6wybwyJG4")
                .globalConfig(builder ->
                        builder.author("guico")
                        .outputDir(path+"/src/main/java/"))
                .packageConfig(builder -> builder.parent("com.guico.authorplat"))
                .strategyConfig(builder -> builder.addInclude("t_user","t_role","t_permission","t_article","t_category", "t_tag")
                        .addTablePrefix("t_")
                        .controllerBuilder().enableRestStyle()//开启@RestController而非@Controller
                        .mapperBuilder().mapperAnnotation(Mapper.class)//开启@Mapper注解

                )


                .execute();
    }
}