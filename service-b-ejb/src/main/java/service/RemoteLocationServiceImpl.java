package service;

import dto.LocationDto;
import mapper.LocationMapper;
import mapper.LocationMapper;
import model.Location;
import model.IdableClass;
import model.Location;
import remote.RemoteCoordinatesService;
import remote.RemoteLocationService;
import repository.LocationRepository;
import repository.LocationRepository;
import dto.LocationDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class RemoteLocationServiceImpl implements RemoteLocationService {

//    @Inject
//    public LocationService(LocationRepository repository,
//                           LocationMapper mapper) {
//        super(repository, mapper);
//    }
//
//    public LocationService() {
//    }


    protected LocationRepository repository;
    protected LocationMapper mapper;

    public RemoteLocationServiceImpl(LocationRepository repository,
                                     LocationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RemoteLocationServiceImpl() {
    }

    public List<LocationDto> getAll() {
        return mapper.mapEntitiesToDtos(repository.findAll());
    }

    public LocationDto getById(Integer id) {
        return mapper.mapToDto(repository.getById(id));
    }

    public LocationDto create(LocationDto createDto) {
        return mapper.mapToDto(repository.create(mapper.mapToEntity(createDto)));
    }

    public LocationDto update(Integer id, LocationDto updateDto) {
        Location updateEntity = mapper.mapToEntity(updateDto);

//        if (classRegistry.contains(updateEntity.getClass()))
//            ((IdableClass) updateEntity).setId(id);

        return mapper.mapToDto(repository.update(id, updateEntity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
