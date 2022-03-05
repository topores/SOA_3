package service;

import mapper.BasicEntityDtoMapper;
import mapper.CoordinatesMapper;
import model.Coordinates;
import model.IdableClass;
import remote.RemoteCoordinatesService;
import repository.AbstractCrudRepository;
import repository.CoordinatesRepository;
import dto.CoordinatesDto;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
//@Stateless
public class RemoteCoordinatesServiceImpl implements RemoteCoordinatesService {
//
//    @Inject
//    public CoordinatesService(CoordinatesRepository repository,
//                              CoordinatesMapper mapper) {
//        super(repository, mapper);
//    }
//
//    public CoordinatesService() {
//    }




    protected CoordinatesRepository repository;
    protected CoordinatesMapper mapper;

    public RemoteCoordinatesServiceImpl(CoordinatesRepository repository,
                                        CoordinatesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RemoteCoordinatesServiceImpl() {
    }

    public List<CoordinatesDto> getAll() {
        return mapper.mapEntitiesToDtos(repository.findAll());
    }

    public CoordinatesDto getById(Integer id) {
        return mapper.mapToDto(repository.getById(id));
    }

    public CoordinatesDto create(CoordinatesDto createDto) {
        return mapper.mapToDto(repository.create(mapper.mapToEntity(createDto)));
    }

    public CoordinatesDto update(Integer id, CoordinatesDto updateDto) {
        Coordinates updateEntity = mapper.mapToEntity(updateDto);

//        if (classRegistry.contains(updateEntity.getClass()))
//            ((IdableClass) updateEntity).setId(id);

        return mapper.mapToDto(repository.update(id, updateEntity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
