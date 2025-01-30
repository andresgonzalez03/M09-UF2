# Preguntes teòriques

### 1. Per què s'atura l'execució al cap d'un temps?
L'execució s'atura després d'un temps perquè el mètode ferReserva fa un wait quan els fils intenten realitzar reserves quan no hi ha cap plaça disponible.
Això fa que el fil es quedi en espera fins que alguna altra acció faci que el mètode notifyAll() es cridi que passa quan es cancel·la una reserva.

### 2. Què passaria si en lloc d'una probabilitat de 50%-50% fora de 70%(ferReserva)-30%(cancel·lar)? I si foren al revés les probabilitats? -> Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos

#### Porcio de codi amb 50%50%

```java
@Override
    public void run() {
        while(true) {
            if(rnd.nextInt() < 0.5) {
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
```
#### Amb la seva execució
```bash
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-9 ha fet una reserva. Places disponibles: 4
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-5 ha fet una reserva. Places disponibles: 3
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-1 ha fet una reserva. Places disponibles: 2
Assistent-0 ha fet una reserva. Places disponibles: 1
Assistent-9 ha cancel·lat una reserva. Places disponibles: 2
Assistent-4 ha fet una reserva. Places disponibles: 1
Assistent-5 ha cancel·lat una reserva. Places disponibles: 2
Assistent-6 ha fet una reserva. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 ha cancel·lat una reserva. Places disponibles: 2
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-2 ha fet una reserva. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
```
#### Porció de codi amb 70%30%
```java
@Override
    public void run() {
        while(true) {
            if(rnd.nextInt() < 0.7) {
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
```
#### Amb la seva execució
```bash
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-9 ha fet una reserva. Places disponibles: 4
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-5 ha fet una reserva. Places disponibles: 3
Assistent-4 ha fet una reserva. Places disponibles: 2
Assistent-3 ha fet una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
```

#### Porció de codi amb 30%70%
```java
@Override
    public void run() {
        while(true) {
            if(rnd.nextInt() < 0.3) {
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
```

#### Amb la seva execució
```bash
Assistent-0 ha fet una reserva. Places disponibles: 4
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-7 ha fet una reserva. Places disponibles: 3
Assistent-6 ha fet una reserva. Places disponibles: 2
Assistent-5 ha fet una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
```

### 3. Per què creus que cal la llista i no valdria només amb una variable sencera de reserves?
No podrias controlar quin fil ha fet la reserva, quin fil ja té reserva o quin fil intenta cancel·lar una reserva quan abans no la té. Llavors, no podries val·lidar quin fil ha fet reserva o ha cancel·lat, això podria generar un index negatiu de places disponibles