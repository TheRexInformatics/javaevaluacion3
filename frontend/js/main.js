const API_BASE_URL = "http://localhost:8091/api/deadbydaylight";

// -------------------------------
// CARGAR DATOS
// -------------------------------

// Cargar todos los killers
async function cargarKillers() {
  try {
    const response = await fetch(`${API_BASE_URL}/killers`);
    const killers = await response.json();
    console.log("Killers cargados:", killers);
    // Aquí podrías recorrer y renderizar los killers en HTML
  } catch (error) {
    console.error("Error al cargar killers:", error);
  }
}

// Cargar todos los survis
async function cargarSurvis() {
  try {
    const response = await fetch(`${API_BASE_URL}/survis`);
    const survis = await response.json();
    console.log("Survis cargados:", survis);
    // Aquí podrías recorrer y renderizar los survis en HTML
  } catch (error) {
    console.error("Error al cargar survis:", error);
  }
}

// -------------------------------
// GUARDAR NUEVO KILLER
// -------------------------------

async function crearKiller(killerData) {
  try {
    const response = await fetch(`${API_BASE_URL}/killers`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(killerData),
    });

    if (response.ok) {
      Swal.fire("¡Éxito!", "Killer registrado correctamente", "success");
    } else {
      Swal.fire("Error", "No se pudo registrar el killer", "error");
    }
  } catch (error) {
    Swal.fire("Error", "Hubo un problema con la solicitud", "error");
    console.error("Error creando killer:", error);
  }
}

// -------------------------------
// GUARDAR NUEVO SURVI
// -------------------------------

async function crearSurvi(surviData) {
  try {
    const response = await fetch(`${API_BASE_URL}/survis`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(surviData),
    });

    if (response.ok) {
      Swal.fire("¡Éxito!", "Superviviente registrado correctamente", "success");
    } else {
      Swal.fire("Error", "No se pudo registrar el superviviente", "error");
    }
  } catch (error) {
    Swal.fire("Error", "Hubo un problema con la solicitud", "error");
    console.error("Error creando survi:", error);
  }
}

// -------------------------------
// EJEMPLOS DE USO
// -------------------------------

// Estos los puedes borrar cuando conectes tu formulario real
const ejemploKiller = {
  nombre: "Springtrap",
  descripcion: "Animatrónico vengativo que acecha en la oscuridad.",
  habilidad1: "Terror Nocturno",
  habilidad2: "Sigilo Mortal",
  habilidad3: "Acecho Persistente"
};

const ejemploSurvi = {
  nombre: "Leon Scott Kennedy",
  descripcion: "Policía novato que sobrevivió al brote de Raccoon City.",
  perk1: "De Tripas Corazón",
  perk2: "Granada Aturdidora",
  perk3: "Espíritu de Novato"
};

// Puedes llamarlas así desde consola para probar:
// crearKiller(ejemploKiller);
// crearSurvi(ejemploSurvi);
// cargarKillers();
// cargarSurvis();
