//TODO: remove to enable custom character creation
var ADMIN = true;
var TABS_ENABLED = false;
var CLASSES_LOADED = false;
var RACES_LOADED = false;
var RACE_VALIDATED = false;
var RACIAL_BONUSES_APPLIED = false;
var DISPLAY_POWER_COSTS = false;
var CAN_SAVE_CLASS = true;
var CURRENT_TAB;
var CURRENT_TAB_SELECTOR;
var STRENGTH;
var QUICKNESS;
var INTELLIGENCE;
var LEADERSHIP;
var ENDURANCE;
var MOVEMENT = 6;

var STRENGTH_MODIFIERS = [];
var QUICKNESS_MODIFIERS = [];
var INTELLIGENCE_MODIFIERS = [];
var LEADERSHIP_MODIFIERS = [];
var ENDURANCE_MODIFIERS = [];
var MOVEMENT_MODIFIERS = [];

var CLASS_S_MODIFIERS = [];
var CLASS_Q_MODIFIERS = [];
var CLASS_I_MODIFIERS = [];
var CLASS_L_MODIFIERS = [];
var CLASS_E_MODIFIERS = [];
var CLASS_M_MODIFIERS = [];

var POWERS_ARRAY;
var RACIAL_POWER;
var RACIAL_POWER_ICON;
var RACIAL_POWER_SAVED;
var RACIAL_POWER_ICON_SAVED;
var HALF_ELF_CHOICES = [];
var CLASS_POWER_DETAILS = [];
var SELECTED_POWERS = [];
var SELECTED_POWERS_ICONS = [];
var POWER_POINTS = 2.0;

var CHARACTER_CLASS;
var CHARACTER_CLASS_DETAILS;
var CHARACTER_NAME;
var PLAYER_NAME;
var CHARACTER_RACE;

function activateAnimalTooltipster() {
    $('.animal_tooltip').tooltipster({
        contentCloning: true,
        theme: 'tooltipster-borderless',
        updateAnimation: 'null',
        side: ['bottom', 'top'],
        animationDuration: '0',
        delay: '0'
    });
}

function activiateHalfElfTooltipster() {
    $('.half_elf_tooltip').tooltipster({
        contentCloning: true,
        theme: 'tooltipster-borderless',
        updateAnimation: 'null',
        side: ['bottom', 'top'],
        animationDuration: '0',
        delay: '0'
    });
}

function activateRacialTooltipster() {
    $("#racial_power_container").tooltipster({
        contentCloning: true,
        theme: 'tooltipster-borderless',
        updateAnimation: 'null',
        side: ['bottom', 'top'],
        animationDuration: '0',
        delay: '0'
    });
}

function activiateStartPageTooltipster() {
    $('.start_tooltip').tooltipster({
        contentCloning: true,
        theme: 'tooltipster-borderless',
        updateAnimation: 'null',
        side: ['bottom', 'top'],
        animationDuration: '0',
        delay: '0'
    });
}

function activateStewardTooltipster() {
    $('.steward_tooltip').tooltipster({
        contentCloning: true,
        theme: 'tooltipster-borderless',
        updateAnimation: 'null',
        side: ['bottom', 'top'],
        animationDuration: '0',
        delay: '0'
    });
}

function activateTooltipster() {
    $('.tooltip').tooltipster({
        contentCloning: true,
        theme: 'tooltipster-borderless',
        updateAnimation: 'null',
        side: ['bottom', 'top'],
        animationDuration: '0',
        delay: '0'
    });
}

function add(a, b) {
    return a + b;
}

function addRollTotalModifier(rollNum, lowRoll1, lowRoll2) {
    var rollTotal = document.getElementById("roll_total" + rollNum).innerText;
    if (rollTotal.indexOf("(") === -1) {
        rollTotal = (parseInt(rollTotal) + (parseInt(lowRoll1.innerText) + parseInt(lowRoll2.innerText)));
        var modifier = getModifier(rollTotal);
        if (rollTotal == 0) modifier = "-";
        var sign = "";
        if (modifier > 0) sign = "+";
        document.getElementById("roll_total" + rollNum).innerText = rollTotal + " (" + sign + modifier + ")";
    }
}

function animalSingle(ele) {
    var selectedAnimal = selectText(ele);
    if (selectedAnimal !== "") {
        CAN_SAVE_CLASS = true;
    }

    $.get("/beast/nonMounts", function (data, status) {
        var animalInfo = searchBeasts(data, selectedAnimal);
        var animalDiv = createAnimalDisplay(animalInfo);
        animalDiv.id = "animal_div";
        if (document.getElementById("animal_div") == null) {
            document.getElementById("class_modal_body").appendChild(animalDiv);
        }
        else {
            document.getElementById("animal_div").innerHTML = animalDiv.innerHTML;
        }
        activateAnimalTooltipster();
    });
}

function animalShepherd(ele) {
    checkCanSave();
    var selectedAnimal = selectText(ele);
    var cell;
    switch (ele.id) {
        case "trusted_pet_select":
            cell = document.getElementById("trusted_pet");
            break;
        case "pet_2_select":
            cell = document.getElementById("pet_2");
            break;
        case "pet_3_select":
            cell = document.getElementById("pet_3");
            break;
    }
    cell.innerHTML = "";

    $.get("/beast/nonMounts", function (data, status) {
        var animalInfo = searchBeasts(data, selectedAnimal);
        var animalDiv = createAnimalDisplay(animalInfo);
        cell.appendChild(animalDiv);
        activateAnimalTooltipster();
    });
}

function animalConjurer(ele) {
    var selectedAnimal = selectText(ele);
    if (selectedAnimal !== "") {
        CAN_SAVE_CLASS = true;
    }

    $.get("/beast/conjurer", function (data, status) {
        var animalInfo = searchBeasts(data, selectedAnimal);
        var animalDiv = createAnimalDisplay(animalInfo);
        animalDiv.id = "animal_div";
        if (document.getElementById("animal_div") == null) {
            document.getElementById("class_modal_body").appendChild(animalDiv);
        }
        else {
            document.getElementById("animal_div").innerHTML = animalDiv.innerHTML;
        }
        activateAnimalTooltipster();
    });
}

function applyHalfElfBonus(ele) {
    var currentScore = getCurrentScore(ele);
    var newScore = (parseInt(currentScore) + 3);
    var newMod = getModifier(newScore);
    var display = document.getElementById("half_elf_bonus");
    display.innerHTML = currentScore + " + 3  = " +
        "<span id='half_elf_bonus_total'>" + newScore + "</span>" + getModifierText(newMod);
}

function applyHalfElfPenalty(ele) {
    var currentScore = getCurrentScore(ele);
    var newScore = (parseInt(currentScore) - 3);
    var newMod = getModifier(newScore);
    var display = document.getElementById("half_elf_penalty");
    display.innerHTML = currentScore + " - 3  = " +
        "<span id='half_elf_penalty_total'>" + newScore + "</span>" + getModifierText(newMod);
}

function applyHalfOrcBonus(ele) {
    var currentScore = getCurrentScore(ele);
    var newScore = (parseInt(currentScore) + 4);
    var newMod = getModifier(newScore);
    var display = document.getElementById("half_orc_bonus");
    display.innerHTML = currentScore + " + 4  = " +
        "<span id='half_orc_bonus_total'>" + newScore + "</span>" + getModifierText(newMod);

    var abilities = ["Strength", "Quickness", "Intelligence", "Leadership"];
    var index = abilities.indexOf(selectText(ele));
    if (index > -1) {
        abilities.splice(index, 1);
    }

    var bonusScore = getCurrentScore(ele);
    var penalty1 = abilities[0];
    var penaltyScore1 = getScore(penalty1);
    var penalty2 = abilities[1];
    var penaltyScore2 = getScore(penalty2);
    var penalty3 = abilities[2];
    var penaltyScore3 = getScore(penalty3);

    var penalty1Container = document.getElementById("penalty_1");
    var penalty2Container = document.getElementById("penalty_2");
    var penalty3Container = document.getElementById("penalty_3");

    newScore = (parseInt(penaltyScore1) - 2);
    newMod = getModifier(newScore);
    penalty1Container.innerHTML = penalty1 + ": " + penaltyScore1 + " - 2 = " +
        "<span id='penalty_total1'>" + newScore + "</span>" + getModifierText(newMod);

    newScore = (parseInt(penaltyScore2) - 2);
    newMod = getModifier(newScore);
    penalty2Container.innerHTML = penalty2 + ": " + penaltyScore2 + " - 2 = " +
        "<span id='penalty_total2'>" + newScore + "</span>" + getModifierText(newMod);

    newScore = (parseInt(penaltyScore3) - 2);
    newMod = getModifier(newScore);
    penalty3Container.innerHTML = penalty3 + ": " + penaltyScore3 + " - 2 = " +
        "<span id='penalty_total3'>" + newScore + "</span>" + getModifierText(newMod);

}

function applyHighElfBonus(ele) {
    var currentScore = getCurrentScore(ele);
    var newScore = (parseInt(currentScore) + 3);
    var newMod = getModifier(newScore);
    var display = document.getElementById("high_elf_bonus");
    display.innerHTML = currentScore + " + 3  = " +
        "<span id='high_elf_bonus_total'>" + newScore + "</span>" + getModifierText(newMod);
}

function applyHumanBonus(ele) {
    var display = document.getElementById("human_bonus");
    if (selectText(ele).includes("changes")) {
        document.getElementById("human_penalty_select").value = "No ability changes";
        document.getElementById("human_penalty").innerHTML = "";
        display.innerHTML = "";
        return;
    }
    var currentScore = getCurrentScore(ele);
    var newScore = (parseInt(currentScore) + 2);
    var newMod = getModifier(newScore);
    display.innerHTML = currentScore + " + 2  = " +
        "<span id='human_bonus_total'>" + newScore + "</span>" + getModifierText(newMod);
}

function applyHumanPenalty(ele) {
    var display = document.getElementById("human_penalty");
    if (selectText(ele).includes("changes")) {
        document.getElementById("human_bonus_select").value = "No ability changes";
        document.getElementById("human_bonus").innerHTML = "";
        display.innerHTML = "";
        return;
    }
    var currentScore = getCurrentScore(ele);
    var newScore = (parseInt(currentScore) - 2);
    var newMod = getModifier(newScore);
    display.innerHTML = currentScore + " - 2  = " +
        "<span id='human_penalty_total'>" + newScore + "</span>" + getModifierText(newMod);
}

function applyOrcPenalty(ele) {
    var currentScore = getCurrentScore(ele);
    var newScore = (parseInt(currentScore) - 6);
    var newMod = getModifier(newScore);
    var display = document.getElementById("orc_penalty");
    display.innerHTML = currentScore + " - 6  = " +
        "<span id='orc_penalty_total'>" + newScore + "</span>" + getModifierText(newMod);
}

function applyWoodElfBonus(ele) {
    var currentScore = getCurrentScore(ele);
    var newScore = (parseInt(currentScore) + 3);
    var newMod = getModifier(newScore);
    var display = document.getElementById("wood_elf_bonus");
    display.innerHTML = currentScore + " + 3  = " +
        "<span id='wood_elf_bonus_total'>" + newScore + "</span>" + getModifierText(newMod);
}

function autoAdjustAbilitiesByClass(classCombo) {
    // resetClassModifiers();
    var abilitiesSorted = [STRENGTH, QUICKNESS, INTELLIGENCE, LEADERSHIP];
    abilitiesSorted.sort(function (a, b) {  return b - a;  });
    for (var i = 0; i < 4; i++) {
        var ability = classCombo.charAt(i);
        switch (ability) {
            case 'S':
                STRENGTH = abilitiesSorted[i];
                break;
            case 'Q':
                QUICKNESS = abilitiesSorted[i];
                break;
            case 'I':
                INTELLIGENCE = abilitiesSorted[i];
                break;
            case 'L':
                LEADERSHIP = abilitiesSorted[i];
        }
    }
    update_ability_scores();
}

function adjustEndurance(rollNum, el) {
    var lowRoll1 = document.getElementById("roll" + rollNum + "-4");
    var lowRoll2 = document.getElementById("roll" + rollNum + "-5");
    if (selectText(el) !== "Endurance") {
        lowRoll1.classList.remove("low_end_rolls");
        lowRoll2.classList.remove("low_end_rolls");
        document.getElementById("last_plus" + rollNum).classList.remove("last_end_plus");
        addRollTotalModifier(rollNum, lowRoll1, lowRoll2);
        return;
    }
    lowRoll1.classList.add("low_end_rolls");
    lowRoll2.classList.add("low_end_rolls");
    document.getElementById("last_plus" + rollNum).classList.add("last_end_plus");


    removeRollTotalModifier(rollNum, lowRoll1, lowRoll2);
}

function changeTab(id, el) {
    if (!TABS_ENABLED) {
        return;
    }
    if (id !== "ability_body" && id !== "start_body") {
        document.getElementById("ability_scores").style.display = "block";
        update_ability_scores();
    }
    else {
        if (id === "start_body") {
            displaySummary();
            activiateStartPageTooltipster();
        }
        document.getElementById("ability_scores").style.display = "none";
    }
    el.classList.add("menu_tab_selected");
    CURRENT_TAB_SELECTOR.classList.remove("menu_tab_selected");
    document.getElementById(CURRENT_TAB).style.display = "none";
    document.getElementById(id).style.display = "block";
    CURRENT_TAB = id;
    CURRENT_TAB_SELECTOR = el;
}

function changeTabTo(tab) {
    switch (tab) {
        case "name":
            changeTab("name_body", document.getElementById("name_selector"));
            break;
        case "race":
            changeTab("race_body", document.getElementById("race_selector"));
            break;
        case "class":
            changeTab("class_body", document.getElementById("class_selector"));
            break;
        case "powers":
            changeTab("powers_body", document.getElementById("powers_selector"));
            break;
    }
}

function checkCanSave() {
    var canSave = true;
    if (selectText(document.getElementById("trusted_pet_select")) === "") {
        canSave = false;
    }
    if (selectText(document.getElementById("pet_2_select")) === "") {
        canSave = false;
    }
    if (selectText(document.getElementById("pet_3_select")) === "") {
        canSave = false;
    }
    if (canSave) {
        CAN_SAVE_CLASS = true;
    }
}

function createButton(tab) {
    var button = document.createElement("button");
    button.innerText = "Set";
    button.classList.add("start_button");
    button.classList.add("can_save");
    button.setAttribute("onclick", "changeTabTo(\"" + tab + "\")");
    return button;
}

function createAnimalDisplay(animalInfo) {
    var abilitiesDiv = document.createElement("div");
    var powerDiv = document.createElement("div");

    abilitiesDiv.classList.add("animal_stats");
    abilitiesDiv.style.paddingBottom = "2vh";

    abilitiesDiv.innerHTML = "<span>Strength: " + animalInfo.strength + " " + getModifierText(getModifier(animalInfo.strength)) + "</span><br>" +
        "<span>Quickness: " + animalInfo.quickness + " " + getModifierText(getModifier(animalInfo.quickness)) + "</span><br>" +
        "<span>Intelligence: " + animalInfo.intelligence + " " + getModifierText(getModifier(animalInfo.intelligence)) + "</span><br>" +
        "<span>Leadership: " + animalInfo.leadership + " " + getModifierText(getModifier(animalInfo.leadership)) + "</span><br>" +
        "<span>Endurance: " + animalInfo.endurance + "</span><br><br>" +
        "<span>Speed: " + animalInfo.speed + "</span><br>" +
        "<span>Damage: " + (animalInfo.damage > 1 ? "1-" + animalInfo.damage : animalInfo.damage) + "</span><br>";

    abilitiesDiv.appendChild(createAnimalPowerDisplay(animalInfo.powers));

    return abilitiesDiv;
}

function createAnimalPowerDisplay(powerList) {
    var powersContainer = document.createElement("div");

    for (var i = 0; i < powerList.length; i++) {
        var powerInfo = powerList[i];
        var powerDiv = document.createElement("div");
        powerDiv.style.display = "inline-flex";
        powerDiv.style.marginTop = "2vh";
        powerDiv.id = "animal-"+(powerInfo.name.replace(" ", "_"));
        powerDiv.classList.add("animal_tooltip");
        if (powerList.length > 1) {
            if (i===0) {
                powerDiv.style.marginLeft = "7vw";
            }
            else {
                powerDiv.style.marginLeft = "3vw";
            }
        }
        powerDiv.setAttribute("onmouseover", "update_animal_tooltip(" + JSON.stringify(powerInfo) + ", \"" + powerDiv.id + "\")");
        powerDiv.setAttribute("data-tooltip-content", "#tooltip_content");

        var powerImage = document.createElement("img");
        powerImage.style.marginRight = "1vw";
        powerImage.src = powerInfo.imageSrc;

        var powerName = document.createElement("p");
        powerName.innerText = powerInfo.name;

        powerDiv.appendChild(powerImage);
        powerDiv.appendChild(powerName);

        powersContainer.appendChild(powerDiv);
    }
    return powersContainer;
}

function createExtraAnimalPowerDisplay(currentPowers) {
    var powerList;
    $.get("/beast/powers", function (data, status) {
        for (var i = 0; i < currentPowers.length; i++) {
            data = removeAnimalPower(data, currentPowers[i]);
        }
        if (data[0].name === "Versatile"){
            data.splice(0, 1);
        }
        var powerDisplay = createExtraAnimalPowers(data);
        // var powerDisplay = createAnimalPowerDisplay(data);
        // powerDisplay.style.paddingLeft = "4vw";
        document.getElementById("class_modal_body").appendChild(powerDisplay);
        activateAnimalTooltipster();
    });
}

function createExtraAnimalPowers(powerList) {
    var powersContainer = document.createElement("div");
    // powersContainer.appendChild(info);

    var powerTable = document.createElement("table");
    powerTable.style = "border-top:1pt solid black; padding-left:1vw;margin:0;color:black;text-shadow:none;";
    var info = document.createElement("th");
    info.innerText = "Select an additional power for your mount";
    info.colSpan = "4";
    info.style.paddingRight = "4vw";
    powerTable.appendChild(info);

    var row;

    for (var i = 0; i < powerList.length; i++) {
        if (i % 4 === 0) {
            //new row
            row  = document.createElement("tr");
            powerTable.appendChild(row);
        }
        var cell = document.createElement("td");
        var powerInfo = powerList[i];
        var powerDiv = document.createElement("div");
        powerDiv.style.display = "inline-flex";
        powerDiv.style.marginTop = "2vh";
        powerDiv.style.paddingRight = "2vw";
        powerDiv.id = "animal-"+(powerInfo.name.replace(" ", "_"));
        powerDiv.classList.add("animal_tooltip");
        powerDiv.setAttribute("onmouseover", "update_animal_tooltip(" + JSON.stringify(powerInfo) + ", \"" + powerDiv.id + "\")");
        powerDiv.setAttribute("data-tooltip-content", "#tooltip_content");

        var powerImage = document.createElement("img");
        powerImage.style.marginRight = "1vw";
        powerImage.src = powerInfo.imageSrc;

        var powerName = document.createElement("p");
        powerName.innerText = powerInfo.name;

        powerDiv.appendChild(powerImage);
        powerDiv.appendChild(powerName);

        cell.appendChild(powerDiv);
        row.appendChild(cell);
    }
    powersContainer.appendChild(powerTable);
    return powersContainer;

}

function createStewardPowerDisplay(powerList, index) {
    var powersContainer = document.createElement("div");

    for (var i = 0; i < powerList.length; i++) {
        var powerInfo = powerList[i];
        var powerDiv = document.createElement("div");
        powerDiv.style.display = "inline-flex";
        powerDiv.style.marginTop = "2vh";
        powerDiv.id = "steward-"+index;
        powerDiv.classList.add("steward_tooltip");
        powerDiv.setAttribute("onmouseover", "update_animal_tooltip(" + JSON.stringify(powerInfo) + ", \"" + powerDiv.id + "\")");
        powerDiv.setAttribute("data-tooltip-content", "#tooltip_content");

        var powerImage = document.createElement("img");
        powerImage.style.marginRight = "1vw";
        powerImage.src = powerInfo.imageSrc;

        var powerName = document.createElement("p");
        powerName.innerText = powerInfo.name;
        powerName.style.textAlign = "left";

        powerDiv.appendChild(powerImage);
        powerDiv.appendChild(powerName);

        powersContainer.appendChild(powerDiv);
    }
    return powersContainer;
}

function displaySummary() {
    var sTotal = parseInt(STRENGTH) + parseInt(sumArray(STRENGTH_MODIFIERS));
    var qTotal = parseInt(QUICKNESS) + parseInt(sumArray(QUICKNESS_MODIFIERS));
    var iTotal = parseInt(INTELLIGENCE) + parseInt(sumArray(INTELLIGENCE_MODIFIERS));
    var lTotal = parseInt(LEADERSHIP) + parseInt(sumArray(LEADERSHIP_MODIFIERS));
    var eTotal = parseInt(ENDURANCE) + parseInt(sumArray(ENDURANCE_MODIFIERS));

    var charName = document.getElementById("start_char_name");
    var player = document.getElementById("start_player");
    var race = document.getElementById("start_race");
    var className = document.getElementById("start_class");
    charName.innerHTML = "";
    player.innerHTML = "";
    race.innerHTML = "";
    className.innerHTML = "";

    CHARACTER_NAME == null ? charName.appendChild(createButton("name")) : charName.innerText = CHARACTER_NAME;
    PLAYER_NAME == null ? player.appendChild(createButton("name")) : player.innerText = PLAYER_NAME;
    CHARACTER_RACE == null ? race.appendChild(createButton("race")) : race.innerText = CHARACTER_RACE;
    CHARACTER_CLASS == null ? className.appendChild(createButton("class")) : className.innerText = CHARACTER_CLASS;

    document.getElementById("start_s").innerText = sTotal + getModifierText(getModifier(sTotal));
    document.getElementById("start_q").innerText = qTotal + getModifierText(getModifier(qTotal));
    document.getElementById("start_i").innerText = iTotal + getModifierText(getModifier(iTotal));
    document.getElementById("start_l").innerText = lTotal + getModifierText(getModifier(lTotal));
    document.getElementById("start_e").innerText = eTotal;

    document.getElementById("start_racial_powers_div").innerHTML = "";
    if (RACIAL_POWER_ICON_SAVED !== undefined && CHARACTER_RACE !== undefined) {
        var racialPower = RACIAL_POWER_ICON_SAVED;
        racialPower.id = racialPower.id + "_cloned";
        racialPower.setAttribute("data-tooltip-content", "#tooltip_content");
        racialPower.setAttribute("onmouseover", "update_start_racial_tooltip(this)");

        racialPower.style.marginLeft = "";
        racialPower.style.marginTop = "";
        racialPower.classList.remove("power_selected");
        racialPower.classList.remove("power_div");
        racialPower.classList.add("start_power_div");
        racialPower.classList.add("start_power_display");
        racialPower.classList.add("start_tooltip");
        document.getElementById("start_racial_powers_div").appendChild(racialPower);
    }

    document.getElementById("start_powers_div").innerHTML = "";
    if (SELECTED_POWERS_ICONS.length === 0) {
        var powers = document.getElementById("start_powers_div");
        powers.appendChild(createButton("powers"));
    }
    for (var i = 0; i < SELECTED_POWERS_ICONS.length; i++) {
        var power = SELECTED_POWERS_ICONS[i];
        power.setAttribute("data-tooltip-content", "#tooltip_content");
        power.setAttribute("onmouseover", "update_start_tooltip(this)");

        power.classList.remove("power_selected");
        power.classList.remove("power_div");
        power.classList.add("start_power_div");
        power.classList.add("start_power_display");
        power.classList.add("start_tooltip");
        document.getElementById("start_powers_div").appendChild(power);
    }
}

function enableTabs() {
    TABS_ENABLED = true;
    var tabs = document.getElementsByClassName("menu_tab");
    for (var i = 0; i < tabs.length; i++) {
        tabs.item(i).classList.remove("disabled_menu_item");
    }
}

function getModifier(num) {
    if (num > 20) {
        return 4; //19, 16, 12, 10
    }
    if (num >= 19) {
        return 3;
    }
    if (num >= 16) {
        return 2;
    }
    if (num >= 12) {
        return 1;
    }
    if (num >= 10) {
        return 0;
    }
    if (num >= 6) {
        return -1;
    }
    if (num >= 3) {
        return -2;
    }
    return -3;
}

function getModifierText(num) {
    return " (" + (num > 0 ? '+':'') + num + ")";
}

function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max)) + 1 //don't include 0;
}

function hide_class_modal() {
    document.getElementById("class_modal").classList.add("hidden");
}

function hide_race_modal() {
    document.getElementById("race_modal").classList.add("hidden");
}

function loadClassDescription(ele) {
    var selectedClass = selectText(ele).split("(")[0].trim();
    $.get("/class/classDescription/" + selectedClass, function(data, status) {
        document.getElementById("class_description").innerText = data;
        loadClassTraits(selectedClass);
        loadClassRestrictions(selectedClass);
    });
}

function loadClassList() {
    if (CLASSES_LOADED) {
        return;
    }
    $.get("/class/classList", function(data, status){
        for (var i=0; i < data.length; i++) {
            var className = data[i];
            var classSelect = document.getElementById("class_select");
            var option = document.createElement("option");
            option.value = className;
            option.innerText = className;
            classSelect.appendChild(option);
        }
    });
    CLASSES_LOADED = true;
}

function loadClassPowers(className) {
    SELECTED_POWERS = [];
    SELECTED_POWERS_ICONS = [];
    POWER_POINTS = 2.0;
    document.getElementById("power_warning").classList.add("hidden");
    document.getElementById("power_title").innerText = className;
    document.getElementById("power_title_container").classList.remove("hidden");
    document.getElementById("select_class_first").classList.add("hidden");

    $.get("/class/classPowers/" + className, function(data, status) {
        var powersDisplay = document.getElementById("powers_display");
        var powerTable = document.getElementById("power_table");
        document.getElementById("points_remaining").innerHTML = "You have <b id='points'>2</b> power point(s) remaining";
        powerTable.innerHTML = "";
        POWERS_ARRAY = data;
        CLASS_POWER_DETAILS = [];
        for (var i = 0; i < data.length; i+=2) {
            CLASS_POWER_DETAILS.push(data[i]);
            CLASS_POWER_DETAILS.push(data[i+1]);
            var powerRow = document.createElement("tr");
            var cell1 = document.createElement("td");
            var cell2 = document.createElement("td");
            var div1 = document.createElement("div");
            var div2 = document.createElement("div");

            var powerName = data[i].name;
            var powerDescription = data[i].description;
            var imgSrc = data[i].imageSrc;
            var powerName2 = data[i+1].name;
            var powerDescription2 = data[i+1].description;
            var imgSrc2 = data[i+1].imageSrc;

            div1.id = "power-" + i;
            div2.id = "power-" + (i+1);
            div1.classList.add("power_div");
            div2.classList.add("power_div");
            div1.classList.add("tooltip");
            div2.classList.add("tooltip");
            div1.setAttribute("data-tooltip-content", "#tooltip_content");
            div2.setAttribute("data-tooltip-content", "#tooltip_content");
            div1.setAttribute("onmouseover", "update_tooltip(" + i + ")");
            div2.setAttribute("onmouseover", "update_tooltip(" + (i+1) + ")");
            div1.setAttribute("onclick", "powerSelected(this, " + i + ")");
            div2.setAttribute("onclick", "powerSelected(this, " + (i+1) + ")");

            var power = data[i];
            var power2 = data[i+1];

            var powerIcon = document.createElement("img");
            powerIcon.src = power.imageSrc;
            var powerTitle = document.createElement("p");
            powerTitle.classList.add("power_name");
            powerTitle.innerText = power.name;
            div1.appendChild(powerIcon);
            div1.appendChild(powerTitle);

            powerIcon = document.createElement("img");
            powerIcon.src = power2.imageSrc;
            powerTitle = document.createElement("p");
            powerTitle.classList.add("power_name");
            powerTitle.innerText = power2.name;
            div2.appendChild(powerIcon);
            div2.appendChild(powerTitle);

            cell1.appendChild(div1);
            cell2.appendChild(div2);

            powerRow.appendChild(cell1);
            powerRow.appendChild(cell2);
            powerTable.appendChild(powerRow);
        }
        activateTooltipster();
    })
}

function loadClassRestrictions(className) {
    $.get("/class/classRestrictions/" + className, function(data, status) {
        var restrictionList = document.getElementById("class_restrictions");
        restrictionList.innerHTML = "";
        for (var i = 0; i < data.length; i++) {
            var trait = data[i];
            var listElement = document.createElement("li");
            listElement.innerText = trait;
            restrictionList.appendChild(listElement);
        }
        document.getElementById("restrictions_header").classList.remove("hidden");
        document.getElementById("save_class").classList.remove("hidden");
    })
}

function loadClassTraits(className) {
    $.get("/class/classTraits/" + className, function(data, status) {
        var traitList = document.getElementById("class_traits");
        traitList.innerHTML = "";
        for (var i = 0; i < data.length; i++) {
            var trait = data[i];
            var listElement = document.createElement("li");
            listElement.innerText = trait;
            traitList.appendChild(listElement);
        }
        document.getElementById("traits_header").classList.remove("hidden");
    })
}

function loadRacialPowers(race) {
    $.get("/race/racialPowers/" + race, function(data, status) {
        RACIAL_POWER = data;

        var div = document.getElementById("racial_power_container");
        var powerIcon = document.createElement("img");
        powerIcon.src = data.imageSrc;
        var powerList = document.getElementById("racial_powers");
        powerList.innerHTML = data.name;
        document.getElementById("racial_powers_header").classList.remove("hidden");

        div.innerHTML = "";
        div.appendChild(powerIcon);
        div.appendChild(powerList);
        RACIAL_POWER_ICON = div.cloneNode(true);

        activateRacialTooltipster();
    })
}

function loadRacialTraits(race) {
    $.get("/race/racialTraits/" + race, function(data, status) {
        var traitList = document.getElementById("racial_traits");
        traitList.innerHTML = "";
        for (var i = 0; i < data.length; i++) {
            var trait = data[i];
            var listElement = document.createElement("li");
            listElement.innerText = trait;
            traitList.appendChild(listElement);
        }
        document.getElementById("racial_traits_header").classList.remove("hidden");
    })
}

function loadRaceDescription(ele) {
    var selectedRace = selectText(ele).split("(")[0].trim();
    $.get("/race/raceDescription/" + selectedRace, function(data, status) {
        document.getElementById("race_description").innerText = data;
        loadRacialTraits(selectedRace);
        loadRacialPowers(selectedRace);
        // autoAdjustAbilitiesByRace(selectedRace);
    });
    document.getElementById("save_race").classList.remove("hidden");
}

function loadRaceList() {
    if (RACES_LOADED) {
        return;
    }
    $.get("/race/raceList", function(data, status){
        for (var i=0; i < data.length; i++) {
            var race = data[i];
            var raceSelect = document.getElementById("race_select");
            var option = document.createElement("option");
            option.value = race;
            option.innerText = race;
            raceSelect.appendChild(option);
        }
    });
    RACES_LOADED = true;
}

function populateViper() {
    $.get("/beast/viper", function (data, status) {
        var animalInfo = searchBeasts(data, "Viper");
        var animalDiv = createAnimalDisplay(animalInfo);
        animalDiv.id = "animal_div";
        animalDiv.style.paddingTop = "5vh";
        if (document.getElementById("animal_div") == null) {
            document.getElementById("class_modal_body").appendChild(animalDiv);
        }
        else {
            document.getElementById("animal_div").innerHTML = animalDiv.innerHTML;
        }
        activateAnimalTooltipster();
    });
}

function populateMount() {
    var isHobbit = (CHARACTER_RACE === "Hobbit");
    $.get("/beast/mounts", function (data, status) {
        var animalInfo = (isHobbit ? data[1] : data[0]);
        var animalTitle = document.createElement("p");
        animalTitle.classList.add("animal_stats");
        animalTitle.innerHTML = "<u>" + animalInfo.type + ":</u>";
        animalTitle.id = "animal_title";
        animalTitle.style.paddingTop = "4vh";
        animalTitle.style.marginBottom = "4px";
        if (document.getElementById("animal_title") == null) {
            document.getElementById("class_modal_body").appendChild(animalTitle);
        }
        else {
            document.getElementById("animal_title").innerHTML = animalTitle.innerHTML;
        }

        var animalDiv = createAnimalDisplay(animalInfo);
        animalDiv.id = "animal_div";
        if (document.getElementById("animal_div") == null) {
            document.getElementById("class_modal_body").appendChild(animalDiv);
        }
        else {
            document.getElementById("animal_div").innerHTML = animalDiv.innerHTML;
        }
        createExtraAnimalPowerDisplay(animalInfo.powers);
    });
}

function populateStewards() {
    var amount = 3;
    var abilities = ["Strength: ", "Quickness: ", "Intelligence: ", "Leadership: ", "Endurance: "];
    $.get("/class/steward/"+amount, function (data, status) {
        var row = document.getElementById("steward_container");
        row.innerHTML = "";
        for (var i = 0; i < amount; i++) {
            var steward = data[i];
            var container = document.createElement("td");
            container.style.textAlign = "center";
            container.classList.add("steward_cell");
            container.setAttribute("onclick", "setStewardSelected(this)");

            var name = document.createElement("span");
            name.innerHTML = "<u>" + steward.name + "<br></u>";
            name.style = "font-size:14pt;font-family:'Marcellus SC', serif;";
            var info = document.createElement("span");
            info.innerHTML = steward.gender.value + " - " + steward.characterClass + "<br>";

            container.appendChild(name);
            container.appendChild(info);
            for (var j=0; j < 5; j++) {
                var ability = document.createElement("span");
                var cur;
                switch (j) {
                    case 0:
                        cur = steward.strength.baseValue;
                        break;
                    case 1:
                        cur = steward.quickness.baseValue;
                        break;
                    case 2:
                        cur = steward.intelligence.baseValue;
                        break;
                    case 3:
                        cur = steward.leadership.baseValue;
                        break;
                    case 4:
                        cur = steward.endurance;
                        break;
                }
                ability.innerHTML = abilities[j] + cur + "<br>";
                container.appendChild(ability);
            }
            var powerDisplay = createStewardPowerDisplay(steward.powers, i);
            container.appendChild(powerDisplay);
            row.appendChild(container);
        }
        activateStewardTooltipster();
    });
}

function powerSelected(ele, position) {
    var powerCost = POWERS_ARRAY[position].powerCost;
    var powerName = POWERS_ARRAY[position].name;
    if (ele.classList.contains("power_selected")) {
        ele.classList.remove("power_selected");
        POWER_POINTS = (parseFloat(POWER_POINTS) + parseFloat(powerCost));
        document.getElementById("power_warning").classList.add("hidden");
        var index = SELECTED_POWERS.indexOf(powerName);
        if (index > -1) {
            SELECTED_POWERS.splice(index, 1);
            SELECTED_POWERS_ICONS.splice(index, 1);
        }
        document.getElementById("points").innerText = POWER_POINTS.toString();
    }
    else {
        if (POWER_POINTS < powerCost) {
            document.getElementById("power_warning").classList.remove("hidden");
            return; //don't do anything. Player has already selected too many skills;
        }
        ele.classList.add("power_selected");
        SELECTED_POWERS.push(powerName);
        var clonedIcon = ele.cloneNode(true);
        clonedIcon.id = clonedIcon.id + "_cloned";
        clonedIcon.classList.remove("tooltip");
        SELECTED_POWERS_ICONS.push(clonedIcon);
        POWER_POINTS = (parseFloat(POWER_POINTS) - parseFloat(powerCost));
        document.getElementById("points").innerText = POWER_POINTS.toString();
    }
    showSelectedPowers();
}

function racialModifier(sum, total) {
    if (sum == 0) {
        return "";
    }
    return "<span class='racial_modifier'>" + sum + " = " + "<span><u>" + total + "</u></span>"
}

function removeAnimalPower(powersList, power) {
    var index = -1;
    for (var i = 0; i < powersList.length; i++) {
        if (powersList[i].name === power.name) {
            index = i;
            break;
        }
    }
    if (index > -1) {
        powersList.splice(index, 1);
        return powersList;
    }
    return powersList;
}

function removeRollTotalModifier(rollNum, lowRoll1, lowRoll2) {
    var rollTotal = document.getElementById("roll_total" + rollNum).innerText;
    if (rollTotal.indexOf("(") !== -1) {
        rollTotal = (parseInt(rollTotal) - (parseInt(lowRoll1.innerText) + parseInt(lowRoll2.innerText))).toString();
        document.getElementById("roll_total" + rollNum).innerText = rollTotal.split(" ")[0];
    }
}

function resetAbilityModifiers() {
    STRENGTH_MODIFIERS = [];
    QUICKNESS_MODIFIERS = [];
    INTELLIGENCE_MODIFIERS = [];
    LEADERSHIP_MODIFIERS = [];
    ENDURANCE_MODIFIERS = [];
}

function resetClassModifiers() {
    CLASS_S_MODIFIERS = [];
    CLASS_Q_MODIFIERS = [];
    CLASS_I_MODIFIERS = [];
    CLASS_L_MODIFIERS = [];
    CLASS_E_MODIFIERS = [];
    CLASS_M_MODIFIERS = [];
}

function resetClassSelection() {
    document.getElementById("class_select").value = "";
    document.getElementById("class_description").innerText = "";
    document.getElementById("traits_header").classList.add("hidden");
    document.getElementById("restrictions_header").classList.add("hidden");
    document.getElementById("class_traits").innerHTML = "";
    document.getElementById("class_restrictions").innerHTML = "";

    document.getElementById("char_class").innerText = "";
    document.getElementById("char_class").classList.add("hidden");
}

function resetRaceSelection() {
    document.getElementById("race_select").value = "";
    document.getElementById("race_description").innerText = "";
    document.getElementById("racial_traits_header").classList.add("hidden");
    document.getElementById("racial_powers_header").classList.add("hidden");
    document.getElementById("racial_traits").innerHTML = "";
    document.getElementById("racial_powers").innerHTML = "";

    document.getElementById("char_race").innerText = "";
    document.getElementById("char_race").classList.add("hidden");
}

function rollAttribute(rollNum, el) {
    el.classList.add("disabled_button");
    el.disabled = true;
    var rolls = [];
    for (var i = 0; i < 5; i++) {
        rolls.push(getRandomInt(4));
    }
    rolls = rolls.sort(function (a, b) {  return b - a;  });

    for (var roll = 1; roll <= 5; roll++) {
        var element = document.getElementById("roll" + rollNum + "-" + roll).innerText = rolls[roll-1];
    }
    var rollTotal = rolls.reduce(add, 0);
    var modifier = getModifier(rollTotal);
    if (modifier > 0) {
        rollTotal = rollTotal + " (+" + modifier + ")";
    }
    else {
        rollTotal = rollTotal + " (" + modifier + ")";
    }
    document.getElementById("roll_total" + rollNum).innerText = rollTotal;
}

function saveAbilities() {
    var validated = validate();
    if (validated) {
        document.getElementById("validate_error").style.display = "none";
        enableTabs();
        loadClassList();
        resetClassSelection();
        loadRaceList();
        resetRaceSelection();
        //TODO: Reset powers selection
        changeTab("class_body", document.getElementById("class_selector"));
    }
    else {
        document.getElementById("validate_error").style.display = "block";
    }
}

function saveClass() {
    var selectedClass = document.getElementById("class_select").value.split("(")[0].trim();
    var selectedRace = CHARACTER_RACE;
    var validClass = validate_class(selectedRace, selectedClass);
    if (validClass) {
        showClassModal(selectedClass);
    }
    else {
        var errorMessage = document.getElementById("class_validate_error");
        errorMessage.innerText = selectedRace + "s cannot be " + selectedClass + "s. Select a different class or a different race.";
        document.getElementById("class_validate_error").style.display = "block";
    }
}

function saveClassFinal() {
    if(!CAN_SAVE_CLASS) {
        showClassError();
        return;
    }
    var selectedClass = document.getElementById("class_select").value.split("(")[0].trim();
    CHARACTER_CLASS = selectedClass;

    adjustClassMovementSpeed(selectedClass);
    update_ability_scores();
    var classSelect = document.getElementById("class_select");
    var classCombo = selectText(classSelect).split("(")[1].replace("(", "").replace(")", "").trim();
    autoAdjustAbilitiesByClass(classCombo);

    document.getElementById("class_validate_error").style.display = "none";
    document.getElementById("char_class").innerText = selectedClass;
    document.getElementById("char_class").classList.remove("hidden");
    if (CHARACTER_RACE !== undefined) {
        hide_class_modal();
        changeTab("powers_body", document.getElementById("powers_selector"));
    }
    else {
        hide_class_modal();
        changeTab("race_body", document.getElementById("race_selector"));
    }
    loadClassPowers(selectedClass);
}

function saveRace() {
    var selectedClass = CHARACTER_CLASS;
    var selectedRace = document.getElementById("race_select").value;
    RACE_VALIDATED = validate_race(selectedRace, selectedClass);
    if (RACE_VALIDATED) {
        showRaceModal(selectedRace);
    }
    else {
        var errorMessage = document.getElementById("race_validate_error");
        errorMessage.innerText = selectedRace + "s cannot be " + selectedClass + "s. Select a different class or a different race.";
        document.getElementById("race_validate_error").style.display = "block";
    }
}

function saveRace2(selectedRace) {
    MOVEMENT_MODIFIERS = [];
    adjustRacialMovementSpeed(selectedRace);
    RACIAL_POWER_SAVED = RACIAL_POWER;
    RACIAL_POWER_ICON_SAVED = RACIAL_POWER_ICON;
    RACIAL_BONUSES_APPLIED = true;
    document.getElementById("race_modal").classList.add("hidden");
    if (RACE_VALIDATED) {
        CHARACTER_RACE = selectedRace;
        document.getElementById("race_validate_error").style.display = "none";
        document.getElementById("char_race").innerText = selectedRace;
        document.getElementById("char_race").classList.remove("hidden");
        changeTab("powers_body", document.getElementById("powers_selector"));
    }
}

function adjustClassMovementSpeed(className) {
    if (className === "Barbarian" || className === "Ranger" || className === "Burglar") {
        CLASS_M_MODIFIERS.push(1);
    }
    if (className === "Captain") {
        CLASS_M_MODIFIERS.push(-1);
    }
}

function adjustRacialMovementSpeed(race) {
    if (race === "Hobbit") {
        MOVEMENT_MODIFIERS.push(-1);
    }
}

function selectText(element) {
    return element.options[element.selectedIndex].text;
}

function selectValue(element) {
    return element.options[element.selectedIndex].value;
}

function setStewardSelected(ele) {
    CAN_SAVE_CLASS = true;
    var cells = document.getElementsByClassName("steward_cell");
    for (var i = 0; i < cells.length; i++) {
        cells[i].classList.remove("steward_cell_selected");
    }
    ele.classList.add("steward_cell_selected");
}

function showClassError() {
    document.getElementById("class_error").classList.remove("hidden");
}

function hunterDetails(ele) {
    var selectedRace = selectText(ele);
    if (selectedRace !== "") {
        CAN_SAVE_CLASS = true;
    }
}

function weaponMasterDetails(ele) {
    document.getElementById("class_error").innerText = "*Please select your weapon type of choice to continue*";
    var weapon = selectText(ele);
    if (weapon !== "") {
        if (weapon === "Dagger") {
            var one = document.getElementById("1H");
            document.getElementById("class_error").innerText = "*Daggers cannot be 2-Handed*";
            CAN_SAVE_CLASS = one.checked;
        }
        else {
            CAN_SAVE_CLASS = true;
        }
    }
}

function scholarDetails(ele) {
    CAN_SAVE_CLASS = true;
    var decision = ele.innerText;
    if (decision === "Pass") {
        saveClassFinal();
    }
    else {
        var intelligence = INTELLIGENCE;
        var leadership = LEADERSHIP;
        var iDiff = intelligence - leadership;
        var lDiff = leadership - intelligence;
        CLASS_I_MODIFIERS.push(lDiff);
        CLASS_L_MODIFIERS.push(iDiff);
        saveClassFinal();
    }
}

function showClassModal(className) {
    resetClassModifiers();
    showModalButtons();
    document.getElementById("class_modal_content").style = "";
    switch(className) {
        case "Ranger":
            showRequestedModal("single_animal", "*Please select an animal companion to continue*");
            break;
        case "Skinchanger":
            showRequestedModal("single_animal", "*Please select an animal companion to continue*");
            break;
        case "Conjurer":
            showRequestedModal("conjurer", "*Please select an animal companion to continue*");
            break;
        case "Hunter":
            showRequestedModal("hunter", "*Please select an enemy race to continue*");
            break;
        case "Weapon Master":
            showRequestedModal("weapon_master", "*Please select your weapon type of choice to continue*");
            break;
        case "Sorcerer":
            populateViper();
            showRequestedModal("sorcerer", "");
            CAN_SAVE_CLASS = true;
            break;
        case "Outrider":
            populateMount();
            showRequestedModal("outrider", "*Select one additional power for your mount*");
            CAN_SAVE_CLASS = true;
            break;
        case "Scholar":
            hideModalButtons();
            showRequestedModal("scholar", "*Please select whether to swap Intelligence and Leadership scores or not*");
            break;
        case "Necromancer":
            if (CHARACTER_CLASS === "Necromancer") {
                CAN_SAVE_CLASS = true;
                saveClassFinal();
                return;
            }
            CLASS_E_MODIFIERS.push(2);
            showRequestedModal("necromancer", "");
            CAN_SAVE_CLASS = true;
            break;
        case "Shepherd":
            document.getElementById("class_modal_content").style = "width:60%;";
            showRequestedModal("shepherd", "*Please select your three animal companions to continue*");
            break;
        case "Sovereign":
            populateStewards();
            showRequestedModal("sovereign", "*Please select a steward to continue*");
            break;
        default:
            saveClassFinal();
    }
}

function showModalButtons() {
    document.getElementById("class_save_modal").classList.remove("hidden");
    document.getElementById("class_cancel_modal").classList.remove("hidden");
}

function hideModalButtons() {
    document.getElementById("class_save_modal").classList.add("hidden");
    document.getElementById("class_cancel_modal").classList.add("hidden");
}

function showRequestedModal(modal_type, class_error_message) {
    document.getElementById("class_error").innerText = class_error_message;
    CAN_SAVE_CLASS = false;
    var saveButton = document.getElementById("class_save_modal");
    save.setAttribute("onclick", "validate_"+modal_type+"()");

    var classModalBody = document.getElementById("class_modal_body");
    var classModalContent = document.getElementById(modal_type + "_modal_content");
    var contentClone = classModalContent.cloneNode(true);

    document.getElementById("class_modal_header").innerText = "Additional Class Choices";
    classModalBody.innerHTML = "";
    classModalBody.appendChild(contentClone);

    document.getElementById("class_modal").classList.remove("hidden");
}

function showRaceModal(race) {
    var selectedRace = race;
    race = race.toLowerCase();
    race = race.replace("-", "_");
    race = race.replace(" ", "_");

    var acceptButton = document.getElementById("accept_modal_button");
    acceptButton.setAttribute("onclick", "validate_"+race+"('"+selectedRace+"')")

    var raceModal = document.getElementById("race_modal");
    var raceModalBody = document.getElementById("race_modal_body");
    var raceModalContent = document.getElementById(race + "_modal_content");
    var contentClone = raceModalContent.cloneNode(true);
    var raceModalHeader = document.getElementById("race_modal_header");

    var HalfElfPowersDiv = document.createElement("div");
    HalfElfPowersDiv.id = "half_elf_powers_div";
    HalfElfPowersDiv.style.textAlign = "center";

    raceModalHeader.innerText = selectedRace + " Racial Bonuses";
    raceModalBody.innerHTML = "";
    raceModalBody.appendChild(contentClone);
    raceModalBody.appendChild(HalfElfPowersDiv);
    raceModal.classList.remove("hidden");

    switch(selectedRace) {
        case "Dwarf":
            showDwarfAdjustments();
            break;
        case "Half-Elf":
            showHalfElfPowerChoices();
            break;
        case "High Elf":
            showHighElfAdjustments();
            break;
        case "Hobbit":
            showHobbitAdjustments();
            break;
        case "Orc":
            showOrcAdjustments();
            break;
        case "Wood Elf":
            showWoodElfAdjustments();
            break;
    }
}

function showDwarfAdjustments() {
    var currentS = STRENGTH;
    var currentE = ENDURANCE;
    var currentI = INTELLIGENCE;

    var newS = (parseInt(currentS) + 2);
    var newE = (parseInt(currentE) + 2);
    var newI = (parseInt(currentI) - 4);

    var sSpan = document.getElementById("dwarf_s");
    var eSpan = document.getElementById("dwarf_e");
    var iSpan = document.getElementById("dwarf_i");

    var newMod = getModifier(newS);
    sSpan.innerText = currentS + " + 2 = " + newS + getModifierText(newMod);

    newMod = getModifier(newE);
    eSpan.innerText = currentE + " + 2 = " + newE;

    newMod = getModifier(newI);
    iSpan.innerText = currentI + " - 4 = " + newI + getModifierText(newMod);
}

function showHalfElfPowerChoices() {
    // RACIAL_POWER = undefined;
    // RACIAL_POWER_ICON = undefined;
    var humanPower;
    var highElfPower;
    var woodElfPower;
    $.get("/race/HalfElfChoice", function(data, status) {
        HALF_ELF_CHOICES = data;
        humanPower = data[0];
        highElfPower = data[1];
        woodElfPower = data[2];

        var humanDiv = createPower(humanPower, 0);
        var highElfDiv = createPower(highElfPower, 1);
        var woodElfDiv = createPower(woodElfPower, 2);

        var powerDiv = document.getElementById("half_elf_powers_div");
        powerDiv.appendChild(humanDiv);
        powerDiv.appendChild(highElfDiv);
        powerDiv.appendChild(woodElfDiv);

        activiateHalfElfTooltipster();
    });
}

function createPower(power, index) {
    var div = document.createElement("div");
    var imageSrc = document.createElement("img");
    var powerTitle = document.createElement("p");

    div.id = "half_elf-" + index;
    div.classList.add("power_div");
    div.classList.add("half_elf_tooltip");
    div.setAttribute("data-tooltip-content", "#tooltip_content");
    div.setAttribute("onmouseover", "update_half_elf_tooltip(this, " + index + ")");
    div.setAttribute("onclick", "select_race_power(this, " + index + ")");
    div.style.marginLeft = "2vw";

    imageSrc.src = power.imageSrc;
    powerTitle.innerText = power.name;
    powerTitle.classList.add("power_name");

    div.appendChild(imageSrc);
    div.appendChild(powerTitle);
    return div;
}

function select_race_power(ele, index) {
    for (var i = 0; i < 3; i++) {
        var div = document.getElementById("half_elf-" + i);
        div.classList.remove("power_selected");
    }
    ele.classList.add("power_selected");
    RACIAL_POWER = HALF_ELF_CHOICES[index];
    RACIAL_POWER_ICON = ele;
}

function showHighElfAdjustments() {
    var currentS = STRENGTH;
    var newS = (parseInt(currentS) - 2);
    var sSpan = document.getElementById("high_elf_s");

    var newMod = getModifier(newS);
    sSpan.innerText = currentS + " - 2 = " + newS + getModifierText(newMod);
}

function showHobbitAdjustments() {
    var currentQ = STRENGTH;
    var currentI = ENDURANCE;
    var currentS = INTELLIGENCE;

    var newQ = (parseInt(currentQ) + 2);
    var newI = (parseInt(currentI) + 2);
    var newS = (parseInt(currentS) - 4);

    var qSpan = document.getElementById("hobbit_q");
    var iSpan = document.getElementById("hobbit_i");
    var sSpan = document.getElementById("hobbit_s");

    var newMod = getModifier(newQ);
    qSpan.innerText = currentQ + " + 2 = " + newQ + getModifierText(newMod);

    newMod = getModifier(newI);
    iSpan.innerText = currentI + " + 2 = " + newI + getModifierText(newMod);

    newMod = getModifier(newS);
    sSpan.innerText = currentS + " - 4 = " + newS + getModifierText(newMod);
}

function showOrcAdjustments() {
    var currentS = STRENGTH;
    var newS = (parseInt(currentS) + 4);
    var sSpan = document.getElementById("orc_s");

    var newMod = getModifier(newS);
    sSpan.innerText = currentS + " + 4 = " + newS + getModifierText(newMod);
}

function showWoodElfAdjustments() {
    var currentS = STRENGTH;
    var newS = (parseInt(currentS) - 2);
    var sSpan = document.getElementById("wood_elf_s");

    var newMod = getModifier(newS);
    sSpan.innerText = currentS + " - 2 = " + newS + getModifierText(newMod);
}

function showSelectedPowers() {
    var powersContainer = document.getElementById("char_powers_container");
    powersContainer.innerHTML = "";
    var powersHeader = document.createElement("span");
    powersHeader.innerHTML = "<u>Powers: </u>";
    powersContainer.appendChild(powersHeader);

    for (var i = 0; i < SELECTED_POWERS.length; i++) {
        var powerDiv = document.createElement("div");
        var powerName = document.createElement("span");
        powerDiv.style.display = "list-item";
        powerName.innerText = SELECTED_POWERS[i];
        powerDiv.appendChild(powerName);
        powersContainer.appendChild(powerDiv);
    }
}

function startCreation() {
    document.getElementById("welcome_body").style.display = "none";
    document.getElementById("ability_body").style.display = "block";
    CURRENT_TAB = "ability_body";
    CURRENT_TAB_SELECTOR = document.getElementById("ability_selector");
    CURRENT_TAB_SELECTOR.classList.add("menu_tab_selected");
}

function sumArray(array) {
    var sum = 0;
    for(var i = 0; i < array.length; i++) {
        sum += parseInt(array[i]);
    }
    return sum;
}

function update_ability_scores() {
    var sTotal = parseInt(STRENGTH) + parseInt(sumArray(STRENGTH_MODIFIERS) + parseInt(sumArray(CLASS_S_MODIFIERS)));
    var qTotal = parseInt(QUICKNESS) + parseInt(sumArray(QUICKNESS_MODIFIERS) + parseInt(sumArray(CLASS_Q_MODIFIERS)));
    var iTotal = parseInt(INTELLIGENCE) + parseInt(sumArray(INTELLIGENCE_MODIFIERS) + parseInt(sumArray(CLASS_I_MODIFIERS)));
    var lTotal = parseInt(LEADERSHIP) + parseInt(sumArray(LEADERSHIP_MODIFIERS) + parseInt(sumArray(CLASS_L_MODIFIERS)));
    var eTotal = parseInt(ENDURANCE) + parseInt(sumArray(ENDURANCE_MODIFIERS) + parseInt(sumArray(CLASS_E_MODIFIERS)));
    var mTotal = parseInt(MOVEMENT) + parseInt(sumArray(MOVEMENT_MODIFIERS) + parseInt(sumArray(CLASS_M_MODIFIERS)));

    var sMod = getModifier(sTotal);
    var qMod = getModifier(qTotal);
    var iMod = getModifier(iTotal);
    var lMod = getModifier(lTotal);

    document.getElementById("ability_s").innerHTML = sTotal + getModifierText(sMod);
    document.getElementById("ability_q").innerHTML = qTotal + getModifierText(qMod);
    document.getElementById("ability_i").innerHTML = iTotal + getModifierText(iMod);
    document.getElementById("ability_l").innerHTML = lTotal + getModifierText(lMod);
    document.getElementById("ability_e").innerHTML = eTotal;
    document.getElementById("ability_m").innerHTML = mTotal;
}

function update_character_name(ele) {
    CHARACTER_NAME = ele.value;
    document.getElementById("char_name").innerHTML = "<u>" + ele.value + "</u>";
}

function update_player_name(ele) {
    PLAYER_NAME = ele.value;
    document.getElementById("player_name").innerHTML = "<u>" + ele.value + "</u>";
}

function update_animal_tooltip(powerInfo, powerDivId) {
    var div = document.createElement("div");
    div.style = "width:35vw;";
    div.id = "start_power_container_";

    var powerIcon = document.createElement("img");
    powerIcon.id = "start_power_icon_";

    var powerName = document.createElement("span");
    powerName.style = "font-size:14pt;vertical-align:top;padding-left: 1vw;";
    powerName.id = "start_tooltip_power_name_";

    var powerDescription = document.createElement("p");
    powerDescription.style = "margin-top:0;font-size:10pt;";
    powerDescription.id = "start_tooltip_power_description_";

    powerIcon.src = powerInfo.imageSrc;
    powerName.innerText = powerInfo.name;
    powerDescription.innerText = powerInfo.description;
    div.appendChild(powerIcon);
    div.appendChild(powerName);
    div.appendChild(powerDescription);

    powerDivId = "#" + powerDivId;
    $(powerDivId).tooltipster('content', div)
        .tooltipster('open');

}

function update_half_elf_tooltip(ele, index) {
    var powerInfo = HALF_ELF_CHOICES[index];

    var div = document.createElement("div");
    div.style = "width:35vw;";
    div.id = "start_power_container_";

    var powerIcon = document.createElement("img");
    powerIcon.id = "start_power_icon_";

    var powerName = document.createElement("span");
    powerName.style = "font-size:14pt;vertical-align:top;padding-left: 1vw;";
    powerName.id = "start_tooltip_power_name_";

    var powerDescription = document.createElement("p");
    powerDescription.style = "margin-top:0;font-size:10pt;";
    powerDescription.id = "start_tooltip_power_description_";

    powerIcon.src = powerInfo.imageSrc;
    powerName.innerText = powerInfo.name;
    powerDescription.innerText = powerInfo.description;
    div.appendChild(powerIcon);
    div.appendChild(powerName);
    div.appendChild(powerDescription);

    updateHalfElfTooltipster(index, div);

}

function update_racial_tooltip() {
    if (RACIAL_POWER === undefined) {
        return;
    }
    var div = document.createElement("div");
    div.style = "width:35vw;";
    div.id = "power_container";

    var powerIcon = document.createElement("img");
    powerIcon.id = "power_icon";

    var powerName = document.createElement("span");
    powerName.style = "font-size:14pt;vertical-align:top;padding-left: 1vw;";
    powerName.id = "tooltip_power_name";

    var powerDescription = document.createElement("p");
    powerDescription.style = "margin-top:0;font-size:10pt;";
    powerDescription.id = "tooltip_power_description";

    var currentPower = RACIAL_POWER;
    powerIcon.src = currentPower.imageSrc;
    powerName.innerText = currentPower.name;
    powerDescription.innerText = currentPower.description;
    div.appendChild(powerIcon);
    div.appendChild(powerName);
    div.appendChild(powerDescription);

    updateRacialTooltipster(div);

}

function update_start_racial_tooltip(ele) {
    var powerInfo = RACIAL_POWER_SAVED;

    var div = document.createElement("div");
    div.style = "width:35vw;";
    div.id = "start_power_container_";

    var powerIcon = document.createElement("img");
    powerIcon.id = "start_power_icon_";

    var powerName = document.createElement("span");
    powerName.style = "font-size:14pt;vertical-align:top;padding-left: 1vw;";
    powerName.id = "start_tooltip_power_name_";

    var powerDescription = document.createElement("p");
    powerDescription.style = "margin-top:0;font-size:10pt;";
    powerDescription.id = "start_tooltip_power_description_";

    powerIcon.src = powerInfo.imageSrc;
    powerName.innerText = powerInfo.name;
    powerDescription.innerText = powerInfo.description;
    div.appendChild(powerIcon);
    div.appendChild(powerName);
    div.appendChild(powerDescription);

    updateStartTooltipster(ele, div);

}

function update_start_tooltip(ele) {
    var powerDivName = ele.childNodes[1].innerText;
    var powerInfo = searchPowerInfo(powerDivName);

    var div = document.createElement("div");
    div.style = "width:35vw;";
    div.id = "start_power_container_";

    var powerIcon = document.createElement("img");
    powerIcon.id = "start_power_icon_";

    var powerName = document.createElement("span");
    powerName.style = "font-size:14pt;vertical-align:top;padding-left: 1vw;";
    powerName.id = "start_tooltip_power_name_";

    var powerDescription = document.createElement("p");
    powerDescription.style = "margin-top:0;font-size:10pt;";
    powerDescription.id = "start_tooltip_power_description_";

    powerIcon.src = powerInfo.imageSrc;
    powerName.innerText = powerInfo.name;
    powerDescription.innerText = powerInfo.description;
    div.appendChild(powerIcon);
    div.appendChild(powerName);
    div.appendChild(powerDescription);

    updateStartTooltipster(ele, div);
}

function searchPowerInfo(powerName) {
    for (var i = 0; i < CLASS_POWER_DETAILS.length; i++) {
        var power = CLASS_POWER_DETAILS[i];
        if (power.name === powerName.trim()) {
            return power;
        }
    }
}

function searchBeasts(data, animalSelected) {
    for (var i = 0; i < data.length; i++) {
        var temp = data[i];
        if (temp.type === animalSelected) {
            return temp;
        }
    }
}

function update_tooltip(position) {
    var div = document.createElement("div");
    div.style = "width:35vw;";
    div.id = "power_container";

    var powerIcon = document.createElement("img");
    powerIcon.id = "power_icon";

    var powerName = document.createElement("span");
    powerName.style = "font-size:14pt;vertical-align:top;padding-left: 1vw;";
    powerName.id = "tooltip_power_name";

    var pointsRemaining = document.createElement("span");
    pointsRemaining.style.color = "yellow";

    var powerDescription = document.createElement("p");
    powerDescription.style = "margin-top:0;font-size:10pt;";
    powerDescription.id = "tooltip_power_description";

    var currentPower = POWERS_ARRAY[position];
    powerIcon.src = currentPower.imageSrc;
    powerName.innerText = currentPower.name;
    powerDescription.innerText = currentPower.description;

    var costPrefix = "";
    if (currentPower.powerCost == .5) {
        costPrefix = "0";
    }
    pointsRemaining.innerHTML = "<br>Power Cost: " + costPrefix + currentPower.powerCost;
    div.appendChild(powerIcon);
    div.appendChild(powerName);
    div.appendChild(pointsRemaining);
    div.appendChild(powerDescription);

    updateTootipster(div, position);
}

function updateHalfElfTooltipster(index, div) {
    var id = "#" + "half_elf-" + index;
    $(id).tooltipster('content', div)
        .tooltipster('open');
}

function updateRacialTooltipster(div) {
    $("#racial_power_container").tooltipster('content', div)
        .tooltipster('open');
}

function updateStartTooltipster(power, div) {
    var id = "#" + power.id;
    $(id).tooltipster('content', div)
        .tooltipster('open');
}

function updateTootipster(div, position) {
    var divId = "#power-" + position;
    $(divId).tooltipster('content', div)
        .tooltipster('open');
    $.tooltipster.group('power_div');
}

function validate() {
    var abilities = [];
    for (var i = 1; i <= 5; i++) {
        abilities.push(document.getElementById("select" + i));
    }
    for (var j = 0; j < 5; j++) {
        var element = abilities[j];
        for (var k = 0; k < 5; k++) {
            if (j === k) continue;
            var e = abilities[k];
            if (e.options[e.selectedIndex].text === element.options[element.selectedIndex].text) {
                return false;
            }
        }
    }
    for (var h = 0; h < 5; h++) {
        e = abilities[h];
        if (e.options[e.selectedIndex].text === "Strength") {
            STRENGTH = document.getElementById("roll_total" + (h+1)).innerText.split(" ")[0];
        }
        if (e.options[e.selectedIndex].text === "Quickness") {
            QUICKNESS = document.getElementById("roll_total" + (h+1)).innerText.split(" ")[0];
        }
        if (e.options[e.selectedIndex].text === "Intelligence") {
            INTELLIGENCE = document.getElementById("roll_total" + (h+1)).innerText.split(" ")[0];
        }
        if (e.options[e.selectedIndex].text === "Leadership") {
            LEADERSHIP = document.getElementById("roll_total" + (h+1)).innerText.split(" ")[0];
        }
        if (e.options[e.selectedIndex].text === "Endurance") {
            ENDURANCE = document.getElementById("roll_total" + (h+1)).innerText.split(" ")[0];
        }
    }
    return true;
}

function validate_class(race, className) {
    if (race === undefined) {
        return true;
    }
    var data = {"selectedRace": race, "selectedClass": className};
    var json = JSON.stringify(data);
    var isValid = false;
    $.ajax({
        url:"/race/validate",
        type:"POST",
        data:json,
        async: false,
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(response){
            isValid = response;
        }
    });
    return isValid;
}

function validate_dwarf(race) {
    resetAbilityModifiers();
    STRENGTH_MODIFIERS.push(2);
    ENDURANCE_MODIFIERS.push(2);
    INTELLIGENCE_MODIFIERS.push(-4);
    update_ability_scores();
    saveRace2(race);
}

function validate_half_elf(race) {
    resetAbilityModifiers();
    var powerSelected = false;
    for (var i = 0; i < 3; i++) {
        var power = document.getElementById("half_elf-"+i);
        if (power.classList.contains("power_selected")) {
            powerSelected = true;
            break;
        }
    }
    if (!powerSelected) {
        document.getElementById("race_error").innerText = "*Select a racial power*";
        document.getElementById("race_error").classList.remove("hidden");
        return;
    }
    else {
        document.getElementById("race_error").classList.add("hidden");
    }

    var bonusAbility = selectText(document.getElementById("half_elf_bonus_select"));
    var penaltyAbility = selectText(document.getElementById("half_elf_penalty_select"));

    if (bonusAbility === "" || penaltyAbility === "") {
        document.getElementById("race_error").innerText = "*Select an ability bonus and abilty penalty*";
        document.getElementById("race_error").classList.remove("hidden");
        return;
    }
    else {
        document.getElementById("race_error").classList.add("hidden");
    }

    if (bonusAbility === penaltyAbility) {
        document.getElementById("race_error").innerText = "*Bonuses and Penalties cannot be applied to the same ability*";
        document.getElementById("race_error").classList.remove("hidden");
        return;
    }
    else {
        document.getElementById("race_error").classList.add("hidden");
    }

    add_to_modifiers(bonusAbility, 3);
    add_to_modifiers(penaltyAbility, -3);
    update_ability_scores();
    saveRace2(race);
}

function validate_half_orc(race) {
    resetAbilityModifiers();
    var penaltyAbilities = ["Strength", "Quickness", "Intelligence", "Leadership"];
    var bonusAbility = selectText(document.getElementById("half_orc_bonus_select"));

    var index = penaltyAbilities.indexOf(bonusAbility);
    if (index > -1) {
        penaltyAbilities.splice(index, 1);
    }

    add_to_modifiers(bonusAbility, 4);
    for (var i; i < penaltyAbilities.length; i++) {
        add_to_modifiers(penaltyAbilities[i], -2);
    }
    update_ability_scores();
    saveRace2(race);
}

function validate_high_elf(race) {
    resetAbilityModifiers();

    var bonusAbility = selectText(document.getElementById("high_elf_bonus_select"));
    add_to_modifiers(bonusAbility, 3);
    STRENGTH_MODIFIERS.push(-2);

    update_ability_scores();
    saveRace2(race);
}

function validate_hobbit(race) {
    resetAbilityModifiers();
    QUICKNESS_MODIFIERS.push(2);
    INTELLIGENCE_MODIFIERS.push(2);
    STRENGTH_MODIFIERS.push(-4);
    update_ability_scores();
    saveRace2(race);
}

function validate_human(race) {
    resetAbilityModifiers();

    var bonusAbility = selectText(document.getElementById("human_bonus_select"));
    var penaltyAbility = selectText(document.getElementById("human_penalty_select"));
    if (bonusAbility === penaltyAbility) {
        document.getElementById("race_error").classList.remove("hidden");
        return;
    }
    else {
        document.getElementById("race_error").classList.add("hidden");
    }

    if (bonusAbility.includes("changes") || penaltyAbility.includes("changes")) {
        saveRace2(race);
        return;
    }

    add_to_modifiers(bonusAbility, 2);
    add_to_modifiers(penaltyAbility, -2);
    update_ability_scores();
    saveRace2(race);
}

function validate_orc(race) {
    resetAbilityModifiers();

    STRENGTH_MODIFIERS.push(4);
    var penaltyAbility = selectText(document.getElementById("orc_penalty_select"));

    add_to_modifiers(penaltyAbility, -6);
    update_ability_scores();
    saveRace2(race);
}

function validate_wood_elf(race) {
    resetAbilityModifiers();

    var bonusAbility = selectText(document.getElementById("wood_elf_bonus_select"));
    add_to_modifiers(bonusAbility, 3);
    STRENGTH_MODIFIERS.push(-2);

    update_ability_scores();
    saveRace2(race);
}

function validate_race(race, className) {
    if (className === undefined) {
        return true;
    }
    var json = JSON.stringify({"selectedRace": race, "selectedClass": className});
    var isValid = false;
    $.ajax({
        url:"/race/validate",
        type:"POST",
        data:json,
        async: false,
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(response){
            isValid = response;
        }
    });
    return isValid;
}

window.onclick = function(event) {
    var modal = document.getElementById("race_modal");
    var modal2 = document.getElementById("class_modal");
    if (event.target == modal || event.target == modal2) {
        modal.classList.add("hidden");
        modal2.classList.add("hidden");
    }
};

function add_to_modifiers(mod, value) {
    switch (mod) {
        case "Strength":
            STRENGTH_MODIFIERS.push(value);
            break;
        case "Quickness":
            QUICKNESS_MODIFIERS.push(value);
            break;
        case "Intelligence":
            INTELLIGENCE_MODIFIERS.push(value);
            break;
        case "Leadership":
            LEADERSHIP_MODIFIERS.push(value);
            break;
        case "Endurance":
            ENDURANCE_MODIFIERS.push(value);
            break;
    }
}

function getCurrentScore(ele) {
    switch (selectText(ele)) {
        case "Strength":
            return STRENGTH;
        case "Quickness":
            return QUICKNESS;
        case "Intelligence":
            return INTELLIGENCE;
        case "Leadership":
            return LEADERSHIP;
    }
}

function getScore(ability) {
    switch (ability) {
        case "Strength":
            return STRENGTH;
        case "Quickness":
            return QUICKNESS;
        case "Intelligence":
            return INTELLIGENCE;
        case "Leadership":
            return LEADERSHIP;
    }
}

function startGame() {
    if (!ADMIN) {
        var unsetFields = document.getElementsByClassName("can_save");
        if (unsetFields.length > 0) {
            document.getElementById("start_error").classList.remove("hidden");
            return;
        }
    }
    var character = createCharacterObject();
    var charString = JSON.stringify(character);
    $.ajax({
        url: "/character/create",
        type: "POST",
        data: charString,
        contentType: "application/json; charset=utf-8",
        dataType   : "json",
        success    : function(){
            console.log("Character data submitted");
            // window.location.href = "/opening_sequence.html";
        }
    });
}

function createCharacterObject() {
    if (ADMIN) {
        STRENGTH = 14;
        QUICKNESS = 12;
        INTELLIGENCE = 10;
        LEADERSHIP = 8;
        ENDURANCE = 6;
        MOVEMENT = 6;
        CHARACTER_CLASS = "Champion";
        CHARACTER_RACE = "Dwarf";
    }
    return {
        "abilities": {
            "strength": getTotalAbilityScore(STRENGTH, STRENGTH_MODIFIERS, CLASS_S_MODIFIERS),
            "quickness": getTotalAbilityScore(QUICKNESS, QUICKNESS_MODIFIERS, CLASS_Q_MODIFIERS),
            "intelligence": getTotalAbilityScore(INTELLIGENCE, INTELLIGENCE_MODIFIERS, CLASS_I_MODIFIERS),
            "leadership": getTotalAbilityScore(LEADERSHIP, LEADERSHIP_MODIFIERS, CLASS_L_MODIFIERS),
            "endurance": getTotalAbilityScore(ENDURANCE, ENDURANCE_MODIFIERS, CLASS_E_MODIFIERS),
            "movement": getTotalAbilityScore(MOVEMENT, MOVEMENT_MODIFIERS, CLASS_M_MODIFIERS),
            "class": CHARACTER_CLASS,
            "race": CHARACTER_RACE
        },
        "powers": [getPowers()]
    }
}

function getPowers() {
    if (ADMIN) {
        return "Challenge, Charge, Stout and Sturdy";
    }
    var powers = "";
    for (var i = 0; i < SELECTED_POWERS.length; i++) {
        powers += SELECTED_POWERS[i] + ", ";
    }
    powers += RACIAL_POWER.name;
    return powers;
}

function getTotalAbilityScore(ability, raceModifiers, classModifiers) {
    var total = parseInt(ability);
    for (var i = 0; i < raceModifiers.length; i++) {
        total += raceModifiers[i];
    }
    for (i = 0; i < classModifiers.length; i++) {
        total += classModifiers[i];
    }
    return total;
}
