# FUTURAS_EXTENSIONES.md

## 🛠️ Funcionalidades proyectadas para versiones futuras

Este documento lista características que podrían agregarse en futuras versiones del sistema, alineadas con la visión modular, escalable y personalizada del proyecto. No forman parte del primer alcance técnico, pero se contemplan para expansión.

---

### 🤝 Roles compartidos y grupos

- Creación de hogares, parejas o equipos con consolidación financiera grupal.
- Roles por usuario: administrador, colaborador, solo lectura.
- Reportes compartidos entre miembros.

---

### 🗃️ Exportaciones y respaldos

- Generación de reportes en formato PDF, Excel y JSON.
- Envío por email o apps de mensajería.
- Sincronización con almacenamiento externo (Google Drive, Dropbox).
- Backups automáticos semanales.

---

### 📅 Integraciones externas

- Sincronización con Google Calendar para pagos programados.
- Lectura automática de correos SAT o bancarios.
- API externa para importar datos desde bancos u otras apps.

---

### 📍 Geolocalización avanzada

- Registrar ubicación geográfica del gasto (GPS).
- Mostrar mapas de gastos frecuentes.
- Visualizar movimientos según zona.

---

### 🧠 Recomendaciones inteligentes

- Estimación de gastos futuros basada en patrones.
- Sugerencias para cumplir metas según comportamiento financiero.
- Alertas por anomalías o sobrecargo inusual.

---

### 🧑‍🎨 Avatares y motivadores visuales

- Personaje que evoluciona según hábitos financieros (estilo RPG).
- Frases motivadoras personalizadas por semana.
- Vista tipo “Spotify Wrapped” de finanzas anuales.

---

### 🔔 Notificaciones en tiempo real

- Recordatorios por WebSocket o Push (versión web/móvil).
- Alertas de metas, ingresos recurrentes, o gasto excesivo.

---

### 🔐 Seguridad avanzada

- Autenticación biométrica.
- Cifrado de datos sensibles en reposo.
- Opciones de recuperación de cuenta por correo y verificación de identidad.

---

## ⚙️ Alcance técnico inicial (versión 1)

| Módulo | Endpoints estimados |
|--------|---------------------|
| Usuario & autenticación | 4–6 |
| Gasto & ingreso diario | 6–8 |
| Categorías y cuentas | 4–6 |
| Reportes por rango | 3–5 |
| Metas & eventos | 3–4 |
| Modo privado | 2–3 |
| Bitácora & actividad | 1–2 |
| Total aproximado | **24–34** endpoints REST |

---

Este archivo es una herramienta viva: puede crecer conforme se definan nuevas necesidades, sin comprometer la arquitectura base ni los objetivos funcionales actuales.
