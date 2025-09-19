const express = require("express");
const cors = require("cors");
const { Pool } = require("pg");
const path = require("path");

const app = express();
const port = 3000;

// Conexão com PostgreSQL
const pool = new Pool({
  user: "postgres",
  host: "localhost",
  database: "clinica",
  password: "freefire", 
  port: 5432,
});

app.use(cors());
app.use(express.json());

// --- SERVIR O FRONTEND (index.html) ---
app.use(express.static(path.join(__dirname))); 
// Isso faz com que ele sirva o index.html e arquivos no mesmo diretório

// --- ROTAS PACIENTES ---
app.get("/api/pacientes", async (req, res) => {
  try {
    const result = await pool.query("SELECT * FROM pacientes ORDER BY id ASC");
    res.json(result.rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

app.post("/api/pacientes", async (req, res) => {
  const { nome, cpf, data_nascimento, telefone, email } = req.body;
  try {
    const result = await pool.query(
      "INSERT INTO pacientes (nome, cpf, data_nascimento, telefone, email) VALUES ($1,$2,$3,$4,$5) RETURNING *",
      [nome, cpf, data_nascimento, telefone, email]
    );
    res.status(201).json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

app.put("/api/pacientes/:id", async (req, res) => {
  const { id } = req.params;
  const { nome, cpf, data_nascimento, telefone, email } = req.body;
  try {
    const result = await pool.query(
      "UPDATE pacientes SET nome=$1, cpf=$2, data_nascimento=$3, telefone=$4, email=$5 WHERE id=$6 RETURNING *",
      [nome, cpf, data_nascimento, telefone, email, id]
    );
    res.json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

app.delete("/api/pacientes/:id", async (req, res) => {
  const { id } = req.params;
  try {
    await pool.query("DELETE FROM pacientes WHERE id=$1", [id]);
    res.status(204).send();
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// --- ROTAS CONSULTAS ---
app.get("/api/consultas", async (req, res) => {
  try {
    const result = await pool.query("SELECT * FROM consultas ORDER BY id ASC");
    res.json(result.rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

app.post("/api/consultas", async (req, res) => {
  const { paciente_id, medico, data, horario, status } = req.body;
  try {
    const result = await pool.query(
      "INSERT INTO consultas (paciente_id, medico, data, horario, status) VALUES ($1,$2,$3,$4,$5) RETURNING *",
      [paciente_id, medico, data, horario, status]
    );
    res.status(201).json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

app.put("/api/consultas/:id", async (req, res) => {
  const { id } = req.params;
  const { paciente_id, medico, data, horario, status } = req.body;
  try {
    const result = await pool.query(
      "UPDATE consultas SET paciente_id=$1, medico=$2, data=$3, horario=$4, status=$5 WHERE id=$6 RETURNING *",
      [paciente_id, medico, data, horario, status, id]
    );
    res.json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

app.delete("/api/consultas/:id", async (req, res) => {
  const { id } = req.params;
  try {
    await pool.query("DELETE FROM consultas WHERE id=$1", [id]);
    res.status(204).send();
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// --- INICIAR SERVIDOR ---
app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
