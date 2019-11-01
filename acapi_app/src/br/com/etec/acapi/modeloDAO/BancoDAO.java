package br.com.etec.acapi.modeloDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;



import br.com.etec.acapi.conexao.Conexao;
import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modelo.CategoriasProdutos;
import br.com.etec.acapi.modelo.Compra;
import br.com.etec.acapi.modelo.Fornecedor;
import br.com.etec.acapi.modelo.Funcionario;
import br.com.etec.acapi.modelo.Produto;



public class BancoDAO {
		
	//salvar os objetos no Banco de dados
	public Produto salvarProduto(Produto produto) {
		EntityManager em = new Conexao().getConexao();
		em.getTransaction().begin();
		try {
			if(produto.getId() == null) {
				em.persist(produto);
				
			}else {
				em.merge(produto);
			}
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return produto;
	}
	
	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		EntityManager em = new Conexao().getConexao();
		em.getTransaction().begin();
		try {
			if(fornecedor.getId() == null) {
				em.persist(fornecedor);
				
			}else {
				em.merge(fornecedor);
			}
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return fornecedor;
	}
	
	public Carrinho salvarCarrinho(Carrinho carrinho) {
		EntityManager em = new Conexao().getConexao();
		em.getTransaction().begin();
		try {
			if(carrinho.getId() == null) {
				em.persist(carrinho);
				
			}else {
				em.merge(carrinho);
			}
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return carrinho;
	}
	
	public Funcionario salvarFuncionario(Funcionario Funcionario) {
		EntityManager em = new Conexao().getConexao();
		em.getTransaction().begin();
		try {
			if(Funcionario.getId() == null) {
				em.persist(Funcionario);
				
			}else {
				em.merge(Funcionario);
			}
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return Funcionario;
	}
	
	public CategoriasProdutos salvarCategoria(CategoriasProdutos tipo) {
		EntityManager em = new Conexao().getConexao();
		em.getTransaction().begin();
		try {
			if(tipo.getId() == null) {
				em.persist(tipo);
				
			}else {
				em.merge(tipo);
			}
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return tipo;
	}
	
	public Compra salvarCompra(Compra compra) {
		EntityManager em = new Conexao().getConexao();
		em.getTransaction().begin();
		try {
			if(compra.getId() == null) {
				em.persist(compra);
				
			}else {
				em.merge(compra);
			}
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return compra;
	}
	
	//fim do salvamento no banco de dados
	
	
	//Buscar os objetos
	
	public Produto buscarProdutoPorId(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Produto produto = null;

		try {
			produto = em.find(Produto.class, id);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return produto;

	}
	
	public Fornecedor buscarFornecedorPorId(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Fornecedor fornecedor = null;

		try {
			fornecedor = em.find(Fornecedor.class, id);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return fornecedor;

	}
	
	public Funcionario buscarFuncionarioPorId(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Funcionario Funcionario = null;

		try {
			Funcionario = em.find(Funcionario.class, id);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return Funcionario;

	}
	
	public Carrinho buscarCarrinhoPorId(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Carrinho carrinho = null;

		try {
			carrinho = em.find(Carrinho.class, id);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return carrinho;

	}
	
	
	public CategoriasProdutos buscarCategorisPorId(Integer id) {
		EntityManager em = new Conexao().getConexao();
		CategoriasProdutos tipo = null;

		try {
			tipo = em.find(CategoriasProdutos.class, id);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return tipo;

	}
	
	public Compra buscarCompraPorId(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Compra compra = null;

		try {
			compra = em.find(Compra.class, id);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return compra;

	}
	//fim da busca dos objetos
	
	//Começo da busca por lista
	
	public List<Produto> buscaListaProdutos() {
		EntityManager em = new Conexao().getConexao();
		List<Produto> produtos = null;
		try {
			produtos = em.createQuery("from Produto p").getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return produtos;
	}
	
	public List<Fornecedor> buscaListaFornecedor() {
		EntityManager em = new Conexao().getConexao();
		List<Fornecedor> fornecedores = null;
		try {
			fornecedores = em.createQuery("from Fornecedor f").getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return fornecedores;
	}
	
	public List<Carrinho> buscaListaCarrinho() {
		EntityManager em = new Conexao().getConexao();
		List<Carrinho> carrinhos = null;
		try {
			carrinhos = em.createQuery("from Carrinho c").getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return carrinhos;
	}
	
	public List<Funcionario> buscaListaFuncionarios() {
		EntityManager em = new Conexao().getConexao();
		
		List<Funcionario> Funcionarios = null;
		try {
			Funcionarios = em.createQuery("from Funcionario g").getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return Funcionarios;
	}
	
	public List<CategoriasProdutos> buscaListaCategorias() {
		EntityManager em = new Conexao().getConexao();
		List<CategoriasProdutos> tipos = null;
		try {
			tipos = em.createQuery("from CategoriasProdutos c").getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return tipos;
	}
	public List<Compra> buscaListaCompra() {
		EntityManager em = new Conexao().getConexao();
		List<Compra> compras = null;
		try {
			compras = em.createQuery("from Compra c").getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return compras;
	}
	
	//fim da busca por lista
	
	//começo da remoçao de obejetos
	
	public Produto removerProduto(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Produto produto = null;
		try {
			produto = em.find(Produto.class, id);
			
			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return produto;
	}
	
	public Fornecedor removerFornecedor(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Fornecedor fornecedor = null;
		try {
			fornecedor = em.find(Fornecedor.class, id);
			
			em.getTransaction().begin();
			em.remove(fornecedor);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return fornecedor;
	}
	
	public Carrinho removerCarrinho(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Carrinho carrinho = null;
		try {
			carrinho = em.find(Carrinho.class, id);
			
			em.getTransaction().begin();
			em.remove(carrinho);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return carrinho;
	}
	
	public Funcionario removerFuncionario(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Funcionario Funcionario = null;
		try {
			Funcionario = em.find(Funcionario.class, id);
			
			em.getTransaction().begin();
			em.remove(Funcionario);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return Funcionario;
	}
	
	
	public CategoriasProdutos removerCategoria(Integer id) {
		EntityManager em = new Conexao().getConexao();
		CategoriasProdutos tipo = null;
		try {
			tipo = em.find(CategoriasProdutos.class, id);
			
			em.getTransaction().begin();
			em.remove(tipo);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return tipo;
	}
	
	public Compra removerCompra(Integer id) {
		EntityManager em = new Conexao().getConexao();
		Compra compra = null;
		try {
			compra = em.find(Compra.class, id);
			
			em.getTransaction().begin();
			em.remove(compra);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return compra;
	}
	// fim da remoçao de objetos
	
	// Começo das buscas dinamicas
	
	public Produto buscaProdutoPorNome(String nome) {
		EntityManager em = new Conexao().getConexao();
		Produto produto = null;
		String jpql = "select p from Produto p where p.nome = :nome";
	    return produto = em.createQuery(jpql, Produto.class).setParameter("nome", nome).getSingleResult();
	    
	}
	// fim das buscas dinamicas
	//Começo da altenticaçao de usuario
	public Funcionario existeFuncionario(Funcionario funcionario) {

		Funcionario funcionarioLogado = new Funcionario() ;
		EntityManager em = new Conexao().getConexao();
	    TypedQuery<Funcionario> query = em.createQuery(
	                    "select f from Funcionario f where f.usuario = :pUsuario and f.senha = :pSenha",
	                    Funcionario.class);

	    query.setParameter("pUsuario", funcionario.getUsuario());
	    query.setParameter("pSenha", funcionario.getSenha());

	    try {
	        Funcionario resultado = query.getSingleResult(); 
	        funcionarioLogado = query.getSingleResult();
	    } catch (NoResultException ex) {
	        return null;
	    }

	    em.close();

	    return funcionarioLogado;
	    
	}
	
	public List<Produto> produtoCarrinho(Integer id){
		
		EntityManager em = new Conexao().getConexao();
		
		Carrinho carrinho = new Carrinho();
		carrinho.setId(id);
		
		String jpql = "select m from Produto m where m.carrinho = :pCarrinho";
		Query query = em.createQuery(jpql);
		query.setParameter("pCarrinho", carrinho);
		
		
		List<Produto> resultado = query.getResultList();
		
		em.close();
		
		return resultado;
        }
    
		
		
	}
	
	
	

