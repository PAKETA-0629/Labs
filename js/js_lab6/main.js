class Casino {

    numOfSlotMachine;
    money;
    slotMachines = []
    constructor(numOfSlotMachine, money) {
        this.numOfSlotMachine = numOfSlotMachine;
        this.money = money;

        for (let i = 0; i < numOfSlotMachine; i++) {
            this.slotMachines[i] = new slotMachine(money / numOfSlotMachine);
        }
    }

    get getMoney() {
        return this.money;
    }

    get getNumOfMachines() {
        return this.numOfSlotMachine;
    }

    addNewMachine() {
        let slot = new slotMachine(0);
        this.slotMachines.push(slot)
        this.numOfSlotMachine++;
    }

    removeMachineById(id) {
        let money = this.slotMachines[id].getMoney;
        this.slotMachines.slice(id, 1);
        this.numOfSlotMachine--;
        this.money += money;
        for (let i = 0; i < this.numOfSlotMachine; i++) {
            this.addMoneyToMachine(i, this.money / this.numOfSlotMachine);
        }
    }

    addMoneyToMachine(id, money) {
        this.slotMachines[id].money += money;
    }
}

class slotMachine {

    moneyIn;
    constructor(moneyIn) {
        this.moneyIn = moneyIn;
    }

    get getMoney() {
        return this.moneyIn;
    }

    incrementMoney(money) {
        this.moneyIn += money;
    }

    decrementMoney(money) {
        this.moneyIn -= money;
    }
}
let casino = new Casino(5, 1000);
console.log(casino.getMoney);
casino.addNewMachine();
console.log(casino.slotMachines[5].getMoney);
console.log(casino.getNumOfMachines);
casino.removeMachineById(0);
console.log(casino.slotMachines[4].getMoney);