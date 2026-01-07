# QA Test Plan: Lucky Loot Boxes

Generated: 2026-01-07T04:56:09.005Z
Minecraft Version: 1.21.1
Mod ID: luckylootboxes

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 107 |
| Passed | 80 |
| Failed | 22 |
| Warnings | 3 |
| Skipped | 2 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `luckylootboxes.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Iron Pickaxe | `/give @p luckylootboxes:iron_pickaxe` | ☐ | ☐ | ☐ |
| Iron Axe | `/give @p luckylootboxes:iron_axe` | ☐ | ☐ | ☐ |
| Iron Helmet | `/give @p luckylootboxes:iron_helmet` | ☐ | ☐ | ☐ |
| Iron Chestplate | `/give @p luckylootboxes:iron_chestplate` | ☐ | ☐ | ☐ |
| Iron Leggings | `/give @p luckylootboxes:iron_leggings` | ☐ | ☐ | ☐ |
| Iron Boots | `/give @p luckylootboxes:iron_boots` | ☐ | ☐ | ☐ |
| Bow | `/give @p luckylootboxes:bow` | ☐ | ☐ | ☐ |
| Diamond Sword | `/give @p luckylootboxes:diamond_sword` | ☐ | ☐ | ☐ |
| Diamond Helmet | `/give @p luckylootboxes:diamond_helmet` | ☐ | ☐ | ☐ |
| Diamond Chestplate | `/give @p luckylootboxes:diamond_chestplate` | ☐ | ☐ | ☐ |
| Diamond Leggings | `/give @p luckylootboxes:diamond_leggings` | ☐ | ☐ | ☐ |
| Diamond Boots | `/give @p luckylootboxes:diamond_boots` | ☐ | ☐ | ☐ |
| Enchanted Diamond Helmet | `/give @p luckylootboxes:enchanted_diamond_helmet` | ☐ | ☐ | ☐ |
| Enchanted Diamond Chestplate | `/give @p luckylootboxes:enchanted_diamond_chestplate` | ☐ | ☐ | ☐ |
| Enchanted Diamond Leggings | `/give @p luckylootboxes:enchanted_diamond_leggings` | ☐ | ☐ | ☐ |
| Enchanted Diamond Boots | `/give @p luckylootboxes:enchanted_diamond_boots` | ☐ | ☐ | ☐ |
| Vex | `/give @p luckylootboxes:vex` | ☐ | ☐ | ☐ |

### Item Tests

#### Iron Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Iron Pickaxe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Iron Axe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Iron Axe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Iron Helmet

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Iron Helmet"
- [ ] Crafting recipe works

#### Iron Chestplate

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Iron Chestplate"
- [ ] Crafting recipe works

#### Iron Leggings

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Iron Leggings"
- [ ] Crafting recipe works

#### Iron Boots

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Iron Boots"
- [ ] Crafting recipe works

#### Bow

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Bow"
- [ ] Crafting recipe works

#### Diamond Sword

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Diamond Sword"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Diamond Helmet

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Diamond Helmet"
- [ ] Crafting recipe works

#### Diamond Chestplate

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Diamond Chestplate"
- [ ] Crafting recipe works

#### Diamond Leggings

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Diamond Leggings"
- [ ] Crafting recipe works

#### Diamond Boots

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Diamond Boots"
- [ ] Crafting recipe works

#### Enchanted Diamond Helmet

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Enchanted Diamond Helmet"
- [ ] Crafting recipe works

#### Enchanted Diamond Chestplate

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Enchanted Diamond Chestplate"
- [ ] Crafting recipe works

#### Enchanted Diamond Leggings

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Enchanted Diamond Leggings"
- [ ] Crafting recipe works

#### Enchanted Diamond Boots

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Enchanted Diamond Boots"
- [ ] Crafting recipe works

#### Vex

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Vex"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p luckylootboxes:lucky_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Zombie | `/summon luckylootboxes:zombie` | ☐ | ☐ | ☐ |
| Skeleton | `/summon luckylootboxes:skeleton` | ☐ | ☐ | ☐ |
| Creeper | `/summon luckylootboxes:creeper` | ☐ | ☐ | ☐ |
| Enderman | `/summon luckylootboxes:enderman` | ☐ | ☐ | ☐ |
| Vex | `/summon luckylootboxes:vex` | ☐ | ☐ | ☐ |
| Evoker | `/summon luckylootboxes:evoker` | ☐ | ☐ | ☐ |

### Mob Tests

#### Zombie

- [ ] Spawns with `/summon luckylootboxes:zombie`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 3
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)

#### Skeleton

- [ ] Spawns with `/summon luckylootboxes:skeleton`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 2
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:bone (100% chance)
  - [ ] minecraft:arrow (100% chance)

#### Creeper

- [ ] Spawns with `/summon luckylootboxes:creeper`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 4
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:gunpowder (100% chance)

#### Enderman

- [ ] Spawns with `/summon luckylootboxes:enderman`
- [ ] Has correct health: 40
- [ ] Deals expected damage: 7
- [ ] AI behavior works (neutral)
- [ ] Drops loot on death:
  - [ ] minecraft:ender_pearl (100% chance)

#### Vex

- [ ] Spawns with `/summon luckylootboxes:vex`
- [ ] Has correct health: 14
- [ ] Deals expected damage: 9
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:iron_ingot (100% chance)

#### Evoker

- [ ] Spawns with `/summon luckylootboxes:evoker`
- [ ] Has correct health: 24
- [ ] Deals expected damage: 6
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:totem_of_undying (100% chance)

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
