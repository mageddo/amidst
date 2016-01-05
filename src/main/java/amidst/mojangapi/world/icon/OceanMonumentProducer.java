package amidst.mojangapi.world.icon;

import java.util.Arrays;
import java.util.List;

import amidst.documentation.NotThreadSafe;
import amidst.mojangapi.minecraftinterface.RecognisedVersion;
import amidst.mojangapi.world.biome.Biome;
import amidst.mojangapi.world.oracle.BiomeDataOracle;

@NotThreadSafe
public class OceanMonumentProducer extends StructureProducer {
	public OceanMonumentProducer(RecognisedVersion recognisedVersion,
			long seed, BiomeDataOracle biomeDataOracle) {
		super(seed, biomeDataOracle, recognisedVersion);
	}

	@Override
	protected boolean isValidLocation() {
		return isSuccessful() && isValidBiomeAtMiddleOfChunk()
				&& isValidBiomeForStructure();
	}

	@Override
	protected DefaultWorldIconTypes getWorldIconType() {
		return DefaultWorldIconTypes.OCEAN_MONUMENT;
	}

	@Override
	protected List<Biome> getValidBiomesForStructure() {
		// @formatter:off
		// Not sure if the extended biomes count
		return Arrays.asList(
				Biome.ocean,
				Biome.deepOcean,
				Biome.frozenOcean,
				Biome.river,
				Biome.frozenRiver,
				Biome.oceanM,
				Biome.deepOceanM,
				Biome.frozenOceanM,
				Biome.riverM,
				Biome.frozenRiverM
		);
		// @formatter:on
	}

	@Override
	protected List<Biome> getValidBiomesAtMiddleOfChunk() {
		// @formatter:off
		// Not sure if the extended biomes count
		return Arrays.asList(
				Biome.deepOcean
		//		Biome.deepOceanM
		);
		// @formatter:on
	}

	@Override
	protected int updateValue(int value) {
		value *= maxDistanceBetweenScatteredFeatures;
		value += (random.nextInt(distanceBetweenScatteredFeaturesRange) + random
				.nextInt(distanceBetweenScatteredFeaturesRange)) / 2;
		return value;
	}

	@Override
	protected long getMagicNumberForSeed1() {
		return 341873128712L;
	}

	@Override
	protected long getMagicNumberForSeed2() {
		return 132897987541L;
	}

	@Override
	protected long getMagicNumberForSeed3() {
		return 10387313L;
	}

	@Override
	protected byte getMaxDistanceBetweenScatteredFeatures() {
		return 32;
	}

	@Override
	protected byte getMinDistanceBetweenScatteredFeatures() {
		return 5;
	}

	@Override
	protected int getStructureSize() {
		return 29;
	}
}