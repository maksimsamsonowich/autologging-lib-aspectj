package eu.senla.customlibrary.autoconfiguration;

import eu.senla.customlibrary.trackstatus.TrackStatusAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ConditionalOnClass( { TrackStatusAspect.class } )
public class TrackStatusAutoConfiguration {

    @Bean
    public TrackStatusAspect trackStatusAspect() {
        return new TrackStatusAspect();
    }

}
