package service;

import dto.PersonDto;
import mapper.PersonMapper;
import mapper.PersonMapper;
import model.Person;
import model.IdableClass;
import model.Person;
import remote.RemotePersonService;
import repository.PersonRepository;
import repository.PersonRepository;
import dto.PersonDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class RemotePersonServiceImpl implements RemotePersonService {

//    @Inject
//    public PersonService(PersonRepository repository,
//                         PersonMapper mapper) {
//        super(repository, mapper);
//    }
//
//    public PersonService() {
//    }


    protected PersonRepository repository;
    protected PersonMapper mapper;

    public RemotePersonServiceImpl(PersonRepository repository,
                                   PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RemotePersonServiceImpl() {
    }

    public List<PersonDto> getAll() {
        return mapper.mapEntitiesToDtos(repository.findAll());
    }

    public PersonDto getById(Integer id) {
        return mapper.mapToDto(repository.getById(id));
    }

    public PersonDto create(PersonDto createDto) {
        return mapper.mapToDto(repository.create(mapper.mapToEntity(createDto)));
    }

    public PersonDto update(Integer id, PersonDto updateDto) {
        Person updateEntity = mapper.mapToEntity(updateDto);

//        if (classRegistry.contains(updateEntity.getClass()))
//            ((IdableClass) updateEntity).setId(id);

        return mapper.mapToDto(repository.update(id, updateEntity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<PersonDto> findAllByDirectorLessThen(String director) {
        return mapper.mapEntitiesToDtos(((PersonRepository) repository).findAllByDirectorLessThan(director));
    }
}
