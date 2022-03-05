package mapper;

import model.Coordinates;
import dto.CoordinatesDto;
import org.mapstruct.Mapper;

import javax.ejb.Stateless;

@Mapper(componentModel = "CDI")
@Stateless
public abstract class CoordinatesMapper extends BasicEntityDtoMapper<CoordinatesDto, Coordinates> {
}
