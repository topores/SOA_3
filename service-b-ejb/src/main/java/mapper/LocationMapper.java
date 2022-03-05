package mapper;

import model.Location;
import dto.LocationDto;
import org.mapstruct.Mapper;

import javax.ejb.Stateless;

@Mapper(componentModel = "CDI")
@Stateless
public abstract class LocationMapper extends BasicEntityDtoMapper<LocationDto, Location> {
}
