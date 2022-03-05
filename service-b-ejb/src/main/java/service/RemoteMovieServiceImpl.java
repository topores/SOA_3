package service;

import dto.MovieDto;
import mapper.MovieMapper;
import mapper.MovieMapper;
import model.Movie;
import model.IdableClass;
import model.Movie;
import model.MovieGenre;
import remote.RemoteMovieService;
import repository.MovieRepository;
import repository.MovieRepository;
import dto.CountDto;
import dto.MovieDto;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
//@Stateless


//@SessionScoped
public class RemoteMovieServiceImpl implements RemoteMovieService {

//    @Inject
//    public MovieService(MovieRepository repository,
//
//                        MovieMapper mapper) {
//        super(repository, mapper);
//    }
//
//    public MovieService() {
//    }


    protected MovieRepository repository;
    protected MovieMapper mapper;

    public RemoteMovieServiceImpl(MovieRepository repository,
                                  MovieMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RemoteMovieServiceImpl() {
    }

    public List<MovieDto> getAll() {
        return mapper.mapEntitiesToDtos(repository.findAll());
    }

    public MovieDto getById(Integer id) {
        return mapper.mapToDto(repository.getById(id));
    }

    public MovieDto create(MovieDto createDto) {
        return mapper.mapToDto(repository.create(mapper.mapToEntity(createDto)));
    }

    public MovieDto update(Integer id, MovieDto updateDto) {
        Movie updateEntity = mapper.mapToEntity(updateDto);

//        if (classRegistry.contains(updateEntity.getClass()))
//            ((IdableClass) updateEntity).setId(id);

        return mapper.mapToDto(repository.update(id, updateEntity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public CountDto countMoviesByOscarsLessThen(long amount) {
        return CountDto.builder()
                       .count(((MovieRepository) repository).countMoviesByOscarsLessThen(amount))
                       .build();
    }

    public CountDto countMoviesByGenre(MovieGenre genre) {
        return CountDto.builder()
                       .count(((MovieRepository) repository).countMoviesByGenre(genre))
                       .build();
    }

    public List<MovieDto> findAllByGenre(String genre) {
        return mapper.mapEntitiesToDtos(((MovieRepository) repository).findAllByGenre(genre));
    }

    public List<MovieDto> findAllByDirectorId(Integer id) {
        return mapper.mapEntitiesToDtos(((MovieRepository) repository).findAllByDirectorId(id));
    }
}
