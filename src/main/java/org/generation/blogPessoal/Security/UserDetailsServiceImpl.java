package org.generation.blogPessoal.Security;

import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private @Autowired UsuarioRepository usarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<Usuario> optional = usarioRepository.findByUsuario(userName);

        if (optional.isPresent()) {
            return new UserDetailsImpl(optional.get());
        } else {
            throw new UsernameNotFoundException("Usuário não existe");
        }
    }
}
