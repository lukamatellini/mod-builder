# QA Test Plan: Aetherfell Armory

Generated: 2026-01-07T18:27:44.322Z
Minecraft Version: 1.21.1
Mod ID: aetherfellarmory

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 132 |
| Passed | 109 |
| Failed | 18 |
| Warnings | 4 |
| Skipped | 1 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `aetherfellarmory.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Ruby Ingot | `/give @p aetherfellarmory:ruby_ingot` | ☐ | ☐ | ☐ |
| Sapphire Shard | `/give @p aetherfellarmory:sapphire_shard` | ☐ | ☐ | ☐ |
| Dragon Scale | `/give @p aetherfellarmory:dragon_scale` | ☐ | ☐ | ☐ |
| Magic Pizza | `/give @p aetherfellarmory:magic_pizza` | ☐ | ☐ | ☐ |
| Frost Berry | `/give @p aetherfellarmory:frost_berry` | ☐ | ☐ | ☐ |
| Phoenix Feather Cake | `/give @p aetherfellarmory:phoenix_feather_cake` | ☐ | ☐ | ☐ |
| Ruby Helmet | `/give @p aetherfellarmory:ruby_helmet` | ☐ | ☐ | ☐ |
| Ruby Chestplate | `/give @p aetherfellarmory:ruby_chestplate` | ☐ | ☐ | ☐ |
| Ruby Leggings | `/give @p aetherfellarmory:ruby_leggings` | ☐ | ☐ | ☐ |
| Ruby Boots | `/give @p aetherfellarmory:ruby_boots` | ☐ | ☐ | ☐ |
| Dragon Slayer Sword | `/give @p aetherfellarmory:dragon_slayer_sword` | ☐ | ☐ | ☐ |
| Thunder Staff | `/give @p aetherfellarmory:thunder_staff` | ☐ | ☐ | ☐ |
| Void Pickaxe | `/give @p aetherfellarmory:void_pickaxe` | ☐ | ☐ | ☐ |
| Void Ingot | `/give @p aetherfellarmory:void_ingot` | ☐ | ☐ | ☐ |
| Ice | `/give @p aetherfellarmory:ice` | ☐ | ☐ | ☐ |
| Packed Ice | `/give @p aetherfellarmory:packed_ice` | ☐ | ☐ | ☐ |
| Ruby Shard | `/give @p aetherfellarmory:ruby_shard` | ☐ | ☐ | ☐ |

### Item Tests

#### Ruby Ingot

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ruby Ingot"
- [ ] Crafting recipe works

#### Sapphire Shard

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Sapphire Shard"
- [ ] Crafting recipe works

#### Dragon Scale

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Dragon Scale"
- [ ] Crafting recipe works

#### Magic Pizza

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Magic Pizza"
- [ ] Crafting recipe works
- [ ] Right-click action works: effect
- [ ] Cooldown applies (100 ticks)

#### Frost Berry

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Frost Berry"
- [ ] Crafting recipe works
- [ ] Right-click action works: effect
- [ ] Cooldown applies (100 ticks)

#### Phoenix Feather Cake

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Phoenix Feather Cake"
- [ ] Crafting recipe works
- [ ] Right-click action works: effect
- [ ] Cooldown applies (100 ticks)

#### Ruby Helmet

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ruby Helmet"
- [ ] Crafting recipe works

#### Ruby Chestplate

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ruby Chestplate"
- [ ] Crafting recipe works

#### Ruby Leggings

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ruby Leggings"
- [ ] Crafting recipe works

#### Ruby Boots

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ruby Boots"
- [ ] Crafting recipe works

#### Dragon Slayer Sword

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Dragon Slayer Sword"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Thunder Staff

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Thunder Staff"
- [ ] Crafting recipe works
- [ ] Right-click action works: projectile
- [ ] Cooldown applies (20 ticks)

#### Void Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Void Pickaxe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Void Ingot

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Void Ingot"
- [ ] Crafting recipe works

#### Ice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ice"

#### Packed Ice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Packed Ice"

#### Ruby Shard

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ruby Shard"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Ruby Ore | `/give @p aetherfellarmory:ruby_ore` | ☐ | ☐ | ☐ |
| Ruby Block | `/give @p aetherfellarmory:ruby_block` | ☐ | ☐ | ☐ |
| Sapphire Ore | `/give @p aetherfellarmory:sapphire_ore` | ☐ | ☐ | ☐ |
| Magic Crystal Block | `/give @p aetherfellarmory:magic_crystal_block` | ☐ | ☐ | ☐ |
| Lucky Block | `/give @p aetherfellarmory:lucky_block` | ☐ | ☐ | ☐ |
| Ancient Rune Block | `/give @p aetherfellarmory:ancient_rune_block` | ☐ | ☐ | ☐ |
| Dragon Nest Block | `/give @p aetherfellarmory:dragon_nest_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Frost Elemental | `/summon aetherfellarmory:frost_elemental` | ☐ | ☐ | ☐ |
| Shadow Wolf | `/summon aetherfellarmory:shadow_wolf` | ☐ | ☐ | ☐ |
| Crystal Golem | `/summon aetherfellarmory:crystal_golem` | ☐ | ☐ | ☐ |
| Ancient Dragon Boss | `/summon aetherfellarmory:ancient_dragon_boss` | ☐ | ☐ | ☐ |

### Mob Tests

#### Frost Elemental

- [ ] Spawns with `/summon aetherfellarmory:frost_elemental`
- [ ] Has correct health: 40
- [ ] Deals expected damage: 5
- [ ] AI behavior works (passive)
- [ ] Drops loot on death:
  - [ ] aetherfellarmory:ice (100% chance)
  - [ ] aetherfellarmory:packed_ice (100% chance)

#### Shadow Wolf

- [ ] Spawns with `/summon aetherfellarmory:shadow_wolf`
- [ ] Has correct health: 30
- [ ] Deals expected damage: 8
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:bone (100% chance)
  - [ ] minecraft:phantom_membrane (100% chance)

#### Crystal Golem

- [ ] Spawns with `/summon aetherfellarmory:crystal_golem`
- [ ] Has correct health: 70
- [ ] Deals expected damage: 15
- [ ] AI behavior works (neutral)
- [ ] Drops loot on death:
  - [ ] aetherfellarmory:magic_crystal_block (100% chance)
  - [ ] minecraft:iron_ingot (100% chance)

#### Ancient Dragon Boss (Boss)

- [ ] Spawns with `/summon aetherfellarmory:ancient_dragon_boss`
- [ ] Has correct health: 500
- [ ] Deals expected damage: 25
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] aetherfellarmory:dragon_scale (100% chance)
  - [ ] aetherfellarmory:ruby_block (100% chance)
  - [ ] aetherfellarmory:dragon_slayer_sword (100% chance)
- [ ] Boss bar displays correctly
- [ ] Boss phases work (if applicable)

## Structures Checklist

### Dragon Lair
- [ ] Structure generates in world
- [ ] Use `/locate structure aetherfellarmory:dragon_lair` to find
- [ ] Contains expected features

### Crystal Cave
- [ ] Structure generates in world
- [ ] Use `/locate structure aetherfellarmory:crystal_cave` to find
- [ ] Contains expected features

### Pirate Ship
- [ ] Structure generates in world
- [ ] Use `/locate structure aetherfellarmory:pirate_ship` to find
- [ ] Contains expected features

### Wizard Tower
- [ ] Structure generates in world
- [ ] Use `/locate structure aetherfellarmory:wizard_tower` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
