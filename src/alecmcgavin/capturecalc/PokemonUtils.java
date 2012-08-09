package alecmcgavin.capturecalc;

import java.util.Arrays;

public class PokemonUtils {

	private final static String[] POKEMON = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle",
		"Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", 
		"Fearow", "Ekans", "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran", "Nidorina", "Nidoqueen", "Nidoran", 
		"Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish", 
		"Gloom", "Vileplume", "Paras", "Parasect", "Venonat", "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian", "Psyduck", 
		"Golduck", "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag", "Poliwhirl", "Poliwrath", "Abra", "Kadabra", "Alakazam", 
		"Machop", "Machoke", "Machamp", "Bellsprout", "Weepinbell", "Victreebel", "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", 
		"Ponyta", "Rapidash", "Slowpoke", "Slowbro", "Magnemite", "Magneton", "Farfetch", "Doduo", "Dodrio", "Seel", "Dewgong", 
		"Grimer", "Muk", "Shellder", "Cloyster", "Gastly", "Haunter", "Gengar", "Onix", "Drowzee", "Hypno", "Krabby", 
		"Kingler", "Voltorb", "Electrode", "Exeggcute", "Exeggutor", "Cubone", "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", 
		"Weezing", "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu", 
		"Starmie", "Mr", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros", "Magikarp", "Gyarados", "Lapras", 
		"Ditto", "Eevee", "Vaporeon", "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto", "Kabutops", "Aerodactyl", 
		"Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew", "Chikorita", "Bayleef", 
		"Meganium", "Cyndaquil", "Quilava", "Typhlosion", "Totodile", "Croconaw", "Feraligatr", "Sentret", "Furret", "Hoothoot", "Noctowl", 
		"Ledyba", "Ledian", "Spinarak", "Ariados", "Crobat", "Chinchou", "Lanturn", "Pichu", "Cleffa", "Igglybuff", "Togepi", 
		"Togetic", "Natu", "Xatu", "Mareep", "Flaaffy", "Ampharos", "Bellossom", "Marill", "Azumarill", "Sudowoodo", "Politoed", 
		"Hoppip", "Skiploom", "Jumpluff", "Aipom", "Sunkern", "Sunflora", "Yanma", "Wooper", "Quagsire", "Espeon", "Umbreon", 
		"Murkrow", "Slowking", "Misdreavus", "Unown", "Wobbuffet", "Girafarig", "Pineco", "Forretress", "Dunsparce", "Gligar", "Steelix", 
		"Snubbull", "Granbull", "Qwilfish", "Scizor", "Shuckle", "Heracross", "Sneasel", "Teddiursa", "Ursaring", "Slugma", "Magcargo", 
		"Swinub", "Piloswine", "Corsola", "Remoraid", "Octillery", "Delibird", "Mantine", "Skarmory", "Houndour", "Houndoom", "Kingdra", 
		"Phanpy", "Donphan", "Porygon", "Stantler", "Smeargle", "Tyrogue", "Hitmontop", "Smoochum", "Elekid", "Magby", "Miltank", 
		"Blissey", "Raikou", "Entei", "Suicune", "Larvitar", "Pupitar", "Tyranitar", "Lugia", "Ho", "Celebi", "Treecko", 
		"Grovyle", "Sceptile", "Torchic", "Combusken", "Blaziken", "Mudkip", "Marshtomp", "Swampert", "Poochyena", "Mightyena", "Zigzagoon", 
		"Linoone", "Wurmple", "Silcoon", "Beautifly", "Cascoon", "Dustox", "Lotad", "Lombre", "Ludicolo", "Seedot", "Nuzleaf", 
		"Shiftry", "Taillow", "Swellow", "Wingull", "Pelipper", "Ralts", "Kirlia", "Gardevoir", "Surskit", "Masquerain", "Shroomish", 
		"Breloom", "Slakoth", "Vigoroth", "Slaking", "Nincada", "Ninjask", "Shedinja", "Whismur", "Loudred", "Exploud", "Makuhita", 
		"Hariyama", "Azurill", "Nosepass", "Skitty", "Delcatty", "Sableye", "Mawile", "Aron", "Lairon", "Aggron", "Meditite", 
		"Medicham", "Electrike", "Manectric", "Plusle", "Minun", "Volbeat", "Illumise", "Roselia", "Gulpin", "Swalot", "Carvanha", 
		"Sharpedo", "Wailmer", "Wailord", "Numel", "Camerupt", "Torkoal", "Spoink", "Grumpig", "Spinda", "Trapinch", "Vibrava", 
		"Flygon", "Cacnea", "Cacturne", "Swablu", "Altaria", "Zangoose", "Seviper", "Lunatone", "Solrock", "Barboach", "Whiscash", 
		"Corphish", "Crawdaunt", "Baltoy", "Claydol", "Lileep", "Cradily", "Anorith", "Armaldo", "Feebas", "Milotic", "Castform", 
		"Kecleon", "Shuppet", "Banette", "Duskull", "Dusclops", "Tropius", "Chimecho", "Absol", "Wynaut", "Snorunt", "Glalie", 
		"Spheal", "Sealeo", "Walrein", "Clamperl", "Huntail", "Gorebyss", "Relicanth", "Luvdisc", "Bagon", "Shelgon", "Salamence", 
		"Beldum", "Metang", "Metagross", "Regirock", "Regice", "Registeel", "Latias", "Latios", "Kyogre", "Groudon", "Rayquaza", 
		"Jirachi", "Deoxys", "Turtwig", "Grotle", "Torterra", "Chimchar", "Monferno", "Infernape", "Piplup", "Prinplup", "Empoleon", 
		"Starly", "Staravia", "Staraptor", "Bidoof", "Bibarel", "Kricketot", "Kricketune", "Shinx", "Luxio", "Luxray", "Budew", 
		"Roserade", "Cranidos", "Rampardos", "Shieldon", "Bastiodon", "Burmy", "Wormadam", "Mothim", "Combee", "Vespiquen", "Pachirisu", 
		"Buizel", "Floatzel", "Cherubi", "Cherrim", "Shellos", "Gastrodon", "Ambipom", "Drifloon", "Drifblim", "Buneary", "Lopunny", 
		"Mismagius", "Honchkrow", "Glameow", "Purugly", "Chingling", "Stunky", "Skuntank", "Bronzor", "Bronzong", "Bonsly", "Mime", 
		"Happiny", "Chatot", "Spiritomb", "Gible", "Gabite", "Garchomp", "Munchlax", "Riolu", "Lucario", "Hippopotas", "Hippowdon", 
		"Skorupi", "Drapion", "Croagunk", "Toxicroak", "Carnivine", "Finneon", "Lumineon", "Mantyke", "Snover", "Abomasnow", "Weavile", 
		"Magnezone", "Lickilicky", "Rhyperior", "Tangrowth", "Electivire", "Magmortar", "Togekiss", "Yanmega", "Leafeon", "Glaceon", "Gliscor", 
		"Mamoswine", "Porygon", "Gallade", "Probopass", "Dusknoir", "Froslass", "Rotom", "Uxie", "Mesprit", "Azelf", "Dialga", 
		"Palkia", "Heatran", "Regigigas", "Giratina", "Cresselia", "Phione", "Manaphy", "Darkrai", "Shaymin", "Arceus" } ;


	private static int[] CAPTURE_RATES = {45, 45, 45, 45, 45, 45, 45, 45, 45, 255, 120, 45, 255, 120, 45, 255, 120, 45, 255, 127, 255, 90, 255, 90, 190, 75, 255, 90, 235, 120, 45, 235, 
		120, 45, 150, 25, 190, 75, 170, 50, 255, 90, 255, 120, 45, 190, 75, 190, 75, 255, 50, 255, 90, 190, 75, 190, 75, 190, 75, 255, 120, 45, 200, 100, 50, 
		180, 90, 45, 255, 120, 45, 190, 60, 255, 120, 45, 190, 60, 190, 75, 190, 60, 45, 190, 45, 190, 75, 190, 75, 190, 60, 190, 90, 45, 45, 190, 75, 225, 
		60, 190, 60, 90, 45, 190, 75, 45, 45, 45, 190, 60, 120, 60, 30, 45, 45, 225, 75, 225, 60, 225, 60, 45, 45, 45, 45, 45, 45, 45, 255, 45, 45, 
		35, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 25, 3, 3, 3, 45, 45, 45, 3, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 255, 90, 255, 90, 255, 90, 255, 90, 90, 190, 75, 190, 150, 170, 190, 
		75, 190, 75, 235, 120, 45, 45, 190, 75, 65, 45, 255, 120, 45, 45, 235, 120, 75, 255, 90, 45, 45, 30, 70, 45, 225, 45, 60, 190, 75, 190, 60, 25, 
		190, 75, 45, 25, 190, 45, 60, 120, 60, 190, 75, 225, 75, 60, 190, 75, 45, 25, 25, 120, 45, 45, 120, 60, 45, 45, 45, 75, 45, 45, 45, 45, 45, 
		30, 3, 3, 3, 45, 45, 45, 3, 3, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 255, 127, 255, 90, 255, 120, 45, 120, 45, 255, 120, 45, 255, 120, 
		45, 200, 45, 190, 45, 235, 120, 45, 200, 75, 255, 90, 255, 120, 45, 255, 120, 45, 190, 120, 45, 180, 200, 150, 255, 255, 60, 45, 45, 180, 90, 45, 180, 
		90, 120, 45, 200, 200, 150, 150, 150, 225, 75, 225, 60, 125, 60, 255, 150, 90, 255, 60, 255, 255, 120, 45, 190, 60, 255, 45, 90, 90, 45, 45, 190, 75, 
		205, 155, 255, 90, 45, 45, 45, 45, 255, 60, 45, 200, 225, 45, 190, 90, 200, 45, 30, 125, 190, 75, 255, 120, 45, 255, 60, 60, 25, 225, 45, 45, 45, 
		3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 3, 3, 3, 45, 45, 45, 45, 45, 45, 45, 45, 45, 255, 120, 45, 255, 127, 255, 45, 235, 120, 45, 255, 75, 45, 45, 45, 45, 120, 45, 45, 120, 45, 200, 
		190, 75, 190, 75, 190, 75, 45, 125, 60, 190, 60, 45, 30, 190, 75, 120, 225, 60, 255, 90, 255, 145, 130, 30, 100, 45, 45, 45, 50, 75, 45, 140, 60, 
		120, 45, 140, 75, 200, 190, 75, 25, 120, 60, 45, 30, 30, 30, 30, 30, 30, 30, 30, 45, 45, 30, 50, 30, 45, 60, 45, 75, 45, 3, 3, 3, 30, 30, 3, 3, 3, 3, 30, 3, 3, 45, 3, 3, 
		45, 45, 45, 45, 45, 45, 45, 45, 45, 255, 255, 255, 120, 45, 255, 90, 190, 75, 190, 75, 190, 75, 190, 75, 255, 120, 45, 190, 75, 255, 120, 45, 190, 
		45, 120, 60, 255, 180, 90, 45, 255, 120, 45, 45, 45, 255, 120, 45, 255, 120, 45, 190, 75, 190, 75, 25, 25, 180, 90, 45, 120, 60, 60, 255, 190, 75, 
		180, 90, 45, 190, 90, 45, 45, 45, 45, 190, 60, 75, 45, 255, 60, 200, 100, 50, 200, 100, 50, 190, 
		45, 255, 120, 45, 190, 75, 200, 200, 75, 190, 75, 190, 60, 75, 190, 75, 255, 90, 130, 60, 30, 190, 60, 30, 255, 90, 190, 90, 45, 75, 60, 45, 120, 
		60, 25, 200, 75, 75, 180, 45, 45, 190, 90, 120, 45, 45, 190, 60, 190, 60, 90, 90, 45, 45, 45, 45, 15, 3, 3, 3, 3, 3, 45, 45, 3, 3, 
		3, 3, 3, 3 };
	
	private static int[] BASE_HP = {45, 60, 80, 39, 58, 78, 44, 59, 79, 45, 50, 60, 40, 45, 65, 40, 63, 83, 30, 55, 40, 65, 35, 60, 35, 
		60, 50, 75, 55, 70, 90, 46, 61, 81, 70, 95, 38, 73, 115, 140, 40, 75, 45, 60, 75, 35, 60, 60, 70, 10, 35, 
		40, 65, 50, 80, 40, 65, 55, 90, 40, 65, 90, 25, 40, 55, 70, 80, 90, 50, 65, 80, 40, 80, 40, 55, 80, 50, 
		65, 90, 95, 25, 50, 52, 35, 60, 65, 90, 80, 105, 30, 50, 30, 45, 60, 35, 60, 85, 30, 55, 40, 60, 60, 95, 
		50, 60, 50, 50, 90, 40, 65, 80, 105, 250, 65, 105, 30, 55, 45, 80, 30, 60, 40, 70, 65, 65, 65, 65, 75, 20, 
		95, 130, 48, 55, 130, 65, 65, 65, 35, 70, 30, 60, 80, 160, 90, 90, 90, 41, 61, 91, 106, 100, 45, 60, 80, 39, 
		58, 78, 50, 65, 85, 35, 85, 60, 100, 40, 55, 40, 70, 85, 75, 125, 20, 50, 90, 35, 55, 40, 65, 55, 70, 90, 
		75, 70, 100, 70, 90, 35, 55, 75, 55, 30, 75, 65, 55, 95, 65, 95, 60, 95, 60, 48, 190, 70, 50, 75, 100, 65, 
		75, 60, 90, 65, 70, 20, 80, 55, 60, 90, 40, 50, 50, 100, 55, 35, 75, 45, 65, 65, 45, 75, 75, 90, 90, 85, 
		73, 55, 35, 50, 45, 45, 45, 95, 255, 90, 115, 100, 50, 70, 100, 106, 106, 100, 40, 50, 70, 45, 60, 80, 50, 70, 
		100, 35, 70, 38, 78, 45, 50, 60, 50, 60, 40, 60, 80, 40, 70, 90, 40, 60, 40, 60, 28, 38, 68, 40, 70, 60, 
		60, 60, 80, 150, 31, 61, 1, 64, 84, 104, 72, 144, 50, 30, 50, 70, 50, 50, 50, 60, 70, 30, 60, 40, 70, 60, 
		60, 65, 65, 50, 70, 100, 45, 70, 130, 170, 60, 70, 70, 60, 80, 60, 45, 50, 80, 50, 70, 45, 75, 73, 73, 70, 
		70, 50, 110, 43, 63, 40, 60, 66, 86, 45, 75, 20, 95, 70, 60, 44, 64, 20, 40, 99, 65, 65, 95, 50, 80, 70, 
		90, 110, 35, 55, 55, 100, 43, 45, 65, 95, 40, 60, 80, 80, 80, 80, 80, 80, 100, 100, 105, 100, 50, 55, 75, 95, 
		44, 64, 76, 53, 64, 84, 40, 55, 85, 59, 79, 37, 77, 45, 60, 80, 40, 60, 67, 97, 30, 60, 40, 60, 70, 30, 
		70, 60, 55, 85, 45, 70, 76, 111, 75, 90, 150, 55, 65, 60, 100, 49, 71, 45, 63, 103, 57, 67, 50, 20, 100, 76, 
		50, 58, 68, 108, 135, 40, 70, 68, 108, 40, 70, 48, 83, 74, 49, 69, 45, 60, 90, 70, 70, 110, 115, 100, 75, 75, 
		85, 86, 65, 65, 75, 110, 85, 68, 60, 45, 70, 50, 75, 80, 75, 100, 90, 91, 110, 150, 120, 80, 100, 70, 100, 120, 
		100, 45, 60, 75, 65, 90, 110, 55, 75, 95, 45, 60, 45, 65, 85, 41, 64, 50, 75, 50, 75, 50, 75, 76, 116, 50, 
		62, 80, 45, 75, 55, 70, 85, 55, 67, 60, 110, 103, 75, 85, 105, 50, 75, 105, 120, 75, 45, 55, 75, 30, 40, 60, 
		40, 60, 45, 70, 70, 70, 50, 60, 95, 70, 105, 105, 75, 50, 70, 50, 65, 72, 38, 58, 54, 74, 55, 75, 50, 80, 
		40, 60, 55, 75, 45, 60, 70, 45, 65, 110, 62, 75, 36, 51, 71, 60, 80, 55, 50, 70, 69, 114, 55, 100, 165, 50, 
		70, 44, 74, 40, 60, 60, 35, 65, 85, 55, 75, 50, 60, 60, 46, 66, 76, 55, 95, 70, 50, 80, 109, 45, 65, 77, 
		59, 89, 45, 65, 95, 70, 100, 70, 110, 85, 58, 52, 72, 92, 55, 85, 91, 91, 91, 79, 79, 100, 100, 89, 125, 91, 
		100, 100, 71};
	
	public static String[] POKEBALLS = {"Poke Ball", "Great Ball", "Ultra Ball", "Master Ball", "Timer Ball", "Safari Ball",
											"Net Ball", "Dive Ball", "Nest Ball", "Repeat Ball", "Luxury Ball", "Premier Ball", "Quick Ball",
											"Dusk Ball", "Heal Ball", "Cherish Ball"};
	private static float[] BALLVALS = {1, 1.5F, 2, 255, 4, 1.5F, 3, 3.5F, 3, 3, 1, 1, 4, 3.5F, 1, 1};
	
	public static String[] STATUSES = {"None", "Sleeping", "Frozen", "Paralyzed", "Burned", "Poisoned"};
	private static float[] STATUSVALS = {1, 2, 2, 1.5F, 1.5F, 1.5F};
	
	public static String[] GET_POKEMON()
	{
		String[] returnString = new String[POKEMON.length];
		for(int i=0;i<POKEMON.length;i++)
			returnString[i]=POKEMON[i];
		return returnString;
	}
	public static String[] GET_SORTED_POKEMON()
	{
		String[] returnString = new String[POKEMON.length];
		for(int i=0;i<POKEMON.length;i++)
			returnString[i]=POKEMON[i];
		Arrays.sort(returnString);
		return returnString;
	}
	public static float GET_BALL_VALUE(String ball)
	{
		for(int i=0; i< POKEBALLS.length; i++)
		{
			if(POKEBALLS[i].equals(ball))
				return BALLVALS[i];
		}
		return -1;
	}
	public static float GET_STATUS_VALUE(String value)
	{
		for(int i=0; i<STATUSES.length;i++)
		{
			if(STATUSES[i].equals(value))
				return STATUSVALS[i];
		}
		return -1;
	}
	public static int GET_CAPTURE_RATE(String pokemon)
	{

		for(int i=0; i < POKEMON.length; i++)
		{
			if(POKEMON[i].equals(pokemon))
				return CAPTURE_RATES[i];
		}
		return -1;
	}
	
	public static int GET_BASE_HP(String pokemon)
	{
		for(int i=0; i < POKEMON.length; i++)
		{
			if(POKEMON[i].equals(pokemon))
				return BASE_HP[i];
		}
		return -1;
	}
	public static int GET_ID(String pokemon)
	{
		for(int i=0; i < POKEMON.length; i++)
		{
			if(POKEMON[i].equals(pokemon))
				return i;
		}
		return -1;
	}
	
	public static int GET_SORTED_ID(String pokemon)
	{
		for(int i=0; i < GET_SORTED_POKEMON().length; i++)
		{
			if(GET_SORTED_POKEMON()[i].equals(pokemon))
				return i;
		}
		return -1;
	}
	public static double EVALUATE(int maxHP, int currentHP, int catchRate, float ball, float status)
	{
		double catchValue;
		catchValue = (((3*maxHP-2*currentHP)*(catchRate*ball)/(3*maxHP))*status);
		if(catchValue >=255)
			return 1;
		
		double realcap = Math.pow(((Math.pow(2, 20)-Math.pow(2, 4))/Math.sqrt(Math.sqrt((Math.pow(2, 24) - Math.pow(2, 16))/catchValue))+1)/Math.pow(2, 16),4);
		return realcap;
	}
	
}
