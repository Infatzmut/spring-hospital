package pe.edu.upn.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.demo.model.entity.Medico;
import pe.edu.upn.demo.model.repository.MedicoRepository;
import pe.edu.upn.demo.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Medico> findAll() throws Exception {
		return medicoRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Medico> findById(Integer id) throws Exception {
		return medicoRepository.findById(id);
	}
	@Transactional
	@Override
	public Medico save(Medico entity) throws Exception {
		return medicoRepository.save(entity);
	}
	@Transactional
	@Override
	public Medico update(Medico entity) throws Exception {
		return medicoRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		medicoRepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		medicoRepository.deleteAll();
	}

}
