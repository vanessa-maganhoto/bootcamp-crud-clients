package com.vanessamatos.crudclientes.service;

import com.vanessamatos.crudclientes.dto.ClientDto;
import com.vanessamatos.crudclientes.model.Client;
import com.vanessamatos.crudclientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDto insert(ClientDto clientDto){
            Client client = clientRepository.save(clientDto.toEntity());
        return new ClientDto(client);
    }

    @Transactional(readOnly = true)
    public List<ClientDto> findAll(){
        List<Client> list = clientRepository.findAll();
        return list.stream().map(x -> new ClientDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<ClientDto> findAllPaged(PageRequest pageRequest){
        Page<Client> list = clientRepository.findAll(pageRequest);
        return list.map(x -> new ClientDto(x));
    }

    @Transactional(readOnly = true)
    public ClientDto findById(Long id){
        Optional<Client> categoryObj = clientRepository.findById(id);
        Client client = categoryObj.orElseThrow(()-> new ResponseStatusException(NOT_FOUND));
        return new ClientDto(client);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto dto){
        Client currentClient = clientRepository.findById(dto.getId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        currentClient.setName(dto.getName());
        currentClient.setCpf(dto.getCpf());
        currentClient.setIncome(dto.getIncome());
        currentClient.setBirthDate(dto.getBirthDate());
        currentClient.setChildren(dto.getChildren());

        Client updatedClient = clientRepository.save(currentClient);
        return new ClientDto(updatedClient);
    }

    @Transactional
    public void delete(Long id){
        try{
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResponseStatusException(NOT_FOUND, "Cliente nâo encontrada: "+id);
        }
    }
}
