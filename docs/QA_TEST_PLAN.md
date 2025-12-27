# QA Test Plan: Stormforged Sky

Generated: 2025-12-27T20:48:55.336Z
Minecraft Version: 1.21.1
Mod ID: stormforgedsky

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 50 |
| Passed | 49 |
| Failed | 1 |
| Warnings | 0 |
| Skipped | 0 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `stormforgedsky.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Storm Wand | `/give @p stormforgedsky:storm_wand` | ☐ | ☐ | ☐ |
| Heavenly Orb | `/give @p stormforgedsky:heavenly_orb` | ☐ | ☐ | ☐ |
| Storm Essence | `/give @p stormforgedsky:storm_essence` | ☐ | ☐ | ☐ |

### Item Tests

#### Storm Wand

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Storm Wand"
- [ ] Crafting recipe works
- [ ] Right-click action works: projectile
- [ ] Cooldown applies (20 ticks)

#### Heavenly Orb

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Heavenly Orb"
- [ ] Crafting recipe works

#### Storm Essence

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Storm Essence"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Glowing Cobblestone | `/give @p stormforgedsky:glowing_cobblestone` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Sky Watcher | `/summon stormforgedsky:sky_watcher` | ☐ | ☐ | ☐ |

### Mob Tests

#### Sky Watcher

- [ ] Spawns with `/summon stormforgedsky:sky_watcher`
- [ ] Has correct health: 40
- [ ] Deals expected damage: 8
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] stormforgedsky:heavenly_orb (100% chance)

## Structures Checklist

### Sky Ruins
- [ ] Structure generates in world
- [ ] Use `/locate structure stormforgedsky:sky_ruins` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
