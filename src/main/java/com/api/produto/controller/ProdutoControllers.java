package com.api.produto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.model.Produto;
import com.api.produto.repositories.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api("Serviço Produto")
@RestController
@RequestMapping("/api")
public class ProdutoControllers {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@ApiOperation("Retorna uma lista de Produtos")
    @GetMapping("/produtos")
	public List<Produto> findAll() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
	@ApiOperation("Retorna um produto unico")
    @GetMapping("/produtos/{id}")
	public Optional<Produto> findAll(@PathVariable(value = "id")Long id) {
		Optional<Produto> produtos = produtoRepository.findById(id);
		return produtos;
	}
	@ApiOperation("Salva um produto")
    @PostMapping("produto")
	public Produto create(@RequestBody Produto produto) {
		Produto produtosSave = produtoRepository.save(produto);
		return produtosSave;
	}
	@ApiOperation("Deleta um produto")
    @DeleteMapping("/produto")
   	public void deleteProduto(@RequestBody Produto produto) {
   		produtoRepository.delete(produto);
   	}
	@ApiOperation("Atualizar um unico produto")
    @PutMapping("produto")
   	public Produto atualizarProduto(@RequestBody Produto produto) {
   		Produto produtoUpdate = produtoRepository.save(produto);
   		return produtoUpdate;
   	}
}