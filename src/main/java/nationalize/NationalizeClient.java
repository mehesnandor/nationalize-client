package nationalize;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;

/**
 *
 * It's for getting the data from the api which returns a json that contain the possibilitaze of a name grouped by contrys
 * The new instance methode make sure that is working correctly. I honestly just writing without mind so if you dont get what i'm saing , it's totaly right.
 *
 * */

public interface NationalizeClient {

    /**
     *
     * @param name - last name (in a good case but you can put your dog's name if you want)
     *
     * @return the possibilities of the name, or what ever XD
     *
     * @throws feign.FeignException if any error occure in prosseing your data with the cake
     *
     */

    @RequestLine("GET /?name={name}")
    Nationality getNationality(@Param("name") String name);

    /**
     *
     * @return an obj. that implements the api - so make a fuckn' obj. from a json thing. Don't get it? Don't worry. Me ether
     *
     */
    static NationalizeClient newInstance() {
        return Feign.builder()
                .decoder(new GsonDecoder(new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
                .target(NationalizeClient.class, "https://api.nationalize.io/");
    }

}
