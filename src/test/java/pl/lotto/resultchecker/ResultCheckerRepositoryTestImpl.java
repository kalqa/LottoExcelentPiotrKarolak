package pl.lotto.resultchecker;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultCheckerRepositoryTestImpl implements ResultCheckerRepository {


    /*
    * @TODO Testy
    *   existsLotteryTicketDtosByDrawDate
    *
    * */
    Map<String, WinningTicket> database = new ConcurrentHashMap<>();

    @Override
    public WinningTicket save(WinningTicket winningTicket) {
        return database.put(winningTicket.id(), winningTicket);
    }

    public WinningTicket findWinningTicketById(String lotteryId) {
        List<WinningTicket> winningTickets = database.values()
                .stream()
                .filter(e -> e.id().equals(lotteryId))
                .collect(Collectors.toList());

        return winningTickets.get(0);

    }

    @Override
    public boolean existsWinningTicketByDrawDate(LocalDateTime drawDate) {
        long count = database.values()
                .stream()
                .filter(x -> x.drawDate().equals(drawDate))
                .count();
        return count != 0;


    }

    @Override
    public WinningTicket findWinningTicketByDrawDate(LocalDateTime drawDate) {
        return null;
    }


    @Override
    public <S extends WinningTicket> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<WinningTicket> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<WinningTicket> findAll() {
        return null;
    }

    @Override
    public Iterable<WinningTicket> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(WinningTicket entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends WinningTicket> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<WinningTicket> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<WinningTicket> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends WinningTicket> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends WinningTicket> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends WinningTicket> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends WinningTicket> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends WinningTicket> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends WinningTicket> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends WinningTicket> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends WinningTicket> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends WinningTicket, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
