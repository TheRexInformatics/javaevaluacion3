const API_BASE_URL = "http://localhost:8080/api/v1/deadbydaylight";


async function cargarKillers() {
  try {
    const response = await fetch(`${API_BASE_URL}/killers`);
    const killers = await response.json();
    console.log("Killers cargados:", killers);

  } catch (error) {
    console.error("Error al cargar killers:", error);
  }
}

async function cargarSurvis() {
  try {
    const response = await fetch(`${API_BASE_URL}/survis`);
    const survis = await response.json();
    console.log("Survis cargados:", survis);
    
  } catch (error) {
    console.error("Error al cargar survis:", error);
  }
}

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

